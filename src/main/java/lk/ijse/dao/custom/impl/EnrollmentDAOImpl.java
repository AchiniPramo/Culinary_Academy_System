package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.EnrollmentDAO;
import lk.ijse.db.FactoryConfiguration;
import lk.ijse.entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public void save(Enrollment enrollment) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(enrollment);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Enrollment enrollment){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(enrollment);

        transaction.commit();
        session.close();
    }

    @Override
    public Enrollment getEnrollment(String studentId,String programName){
        Enrollment enrollment = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT e " +
                "FROM Enrollment e " +
                "JOIN e.student s " +
                "JOIN e.program c " +
                "WHERE s.studentId = :studentId " +
                "AND c.programName = :programName";

        enrollment = session.createQuery(hql, Enrollment.class)
                .setParameter("studentId", studentId)
                .setParameter("programName", programName)
                .uniqueResult();

        transaction.commit();
        session.close();

        return enrollment;
    }
}
