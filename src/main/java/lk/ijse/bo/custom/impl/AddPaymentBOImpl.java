package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AddPaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CulinaryProgramDAO;
import lk.ijse.dao.custom.EnrollmentDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.CulinaryProgram;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Student;

public class AddPaymentBOImpl implements AddPaymentBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAO(DAOFactory.DAOType.STUDENT);
    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDAO(DAOFactory.DAOType.ENROLLMENT);

    @Override
    public void updateEnrollment(String studentId,String programName,double payment) {
        Student student = studentDAO.getStudent(studentId);
        CulinaryProgram culinaryProgram = culinaryProgramDAO.getProgramsCheckName(programName);
        Enrollment enrollment = enrollmentDAO.getEnrollment(studentId, programName);
        enrollmentDAO.update(new Enrollment(enrollment.getEnrollId(),enrollment.getFirstInstallment(),enrollment.getBalance()-payment,student,culinaryProgram));
    }
}
