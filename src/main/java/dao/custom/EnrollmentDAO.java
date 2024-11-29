package dao.custom;

import dao.SuperDao;
import entity.Enrollment;

public interface EnrollmentDAO extends SuperDao {
    void save(Enrollment enrollment);
    void update(Enrollment enrollment);
    Enrollment getEnrollment(String studentId,String programName);
}
