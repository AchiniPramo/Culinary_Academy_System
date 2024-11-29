package dao.custom.impl;

import dao.custom.QueryDAO;
import db.FactoryConfiguration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Student> getAllProgramsStudent() {
        List<Student> students = null;

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // First, get the total number of culinary programs
        String countProgramsHql = "SELECT COUNT(DISTINCT p.programId) FROM CulinaryPrograms p";
        Query<Long> countQuery = session.createQuery(countProgramsHql, Long.class);
        Long totalPrograms = countQuery.uniqueResult();

        // Query to find students enrolled in all programs
        String hql = "SELECT s FROM Student s " +
                "JOIN s.enrollments e " +
                "GROUP BY s.studentId " +
                "HAVING COUNT(DISTINCT e.program.programId) = :totalPrograms";

        Query<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("totalPrograms", totalPrograms);

        // Execute query and get results
        students = query.getResultList();

        transaction.commit();
        session.close();

        return students;
    }

    @Override
    public List<Object[]> getAllEqualByProgramName(String programName) {
        List<Object[]> results = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s, e, c " +
                "FROM Student s " +
                "JOIN s.enrollments e " +
                "JOIN e.program c " +
                "WHERE c.programName = :programName";

        results = session.createQuery(hql)
                .setParameter("programName", programName)
                .getResultList();

        transaction.commit();
        session.close();

        return results;
    }
}
