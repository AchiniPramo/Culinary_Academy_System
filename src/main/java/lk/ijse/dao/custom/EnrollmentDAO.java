package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Enrollment;

public interface EnrollmentDAO extends SuperDAO {

    void save(Enrollment enrollment);
    void update(Enrollment enrollment);
    Enrollment getEnrollment(String studentId,String programName);
}
