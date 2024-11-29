package dao.custom.impl;

import dao.custom.EnrollmentDAO;
import db.FactoryConfiguration;
import entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EnrollmentDAOImpl  implements EnrollmentDAO {
    @Override
    public void save(Enrollment enrollment) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(enrollment);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Enrollment enrollment) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(enrollment);

        transaction.commit();
        session.close();
    }

    @Override
    public Enrollment getEnrollment(String studentId, String programName) {
        Enrollment enrollment = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT e " +
                "FROM Enrollment e " +
                "JOIN e.student s " +
                "JOIN e.program c " +
                "WHERE s.studentId = :studentId " +
                "AND c.programName = :programName";

        List<Enrollment> enrollments = session.createQuery(hql, Enrollment.class)
                .setParameter("studentId", studentId)
                .setParameter("programName", programName)
                .getResultList();

        transaction.commit();
        session.close();

        if (enrollments.isEmpty()) {
            // No results found
            return null; // or throw an exception if preferred
        } else if (enrollments.size() > 1) {
            // More than one result found, handle this case
            throw new IllegalStateException("Multiple enrollments found for studentId: " + studentId + " and programName: " + programName);
        } else {
            // Exactly one result found
            enrollment = enrollments.get(0);
        }

        return enrollment;
    }
}
