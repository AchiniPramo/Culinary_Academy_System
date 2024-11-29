package bo.custom.impl;

import bo.custom.AddPaymentBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dao.custom.EnrollmentDAO;
import dao.custom.StudentDAO;
import entity.CulinaryPrograms;
import entity.Enrollment;
import entity.Student;

public class AddPaymentBOImpl  implements AddPaymentBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAO(DAOFactory.DAOType.STUDENT);
    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDAO(DAOFactory.DAOType.ENROLLMENT);
    @Override
    public void updateEnrollment(String studentId, String programName, double payment) {
        Student student = studentDAO.getStudent(studentId);
        CulinaryPrograms culinaryProgram = culinaryProgramDAO.getProgramsCheckName(programName);
        Enrollment enrollment = enrollmentDAO.getEnrollment(studentId, programName);
        enrollmentDAO.update(new Enrollment(enrollment.getEnrollId(),enrollment.getFirstInstallment(),enrollment.getBalance()-payment,student,culinaryProgram));
    }
}
