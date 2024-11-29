package bo.custom.impl;

import bo.custom.AddProgramBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dao.custom.EnrollmentDAO;
import dao.custom.StudentDAO;
import dto.CulinaryProgramDTO;
import entity.CulinaryPrograms;
import entity.Enrollment;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class AddProgramBOImpl implements AddProgramBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAO(DAOFactory.DAOType.STUDENT);
    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDAO(DAOFactory.DAOType.ENROLLMENT);
    @Override
    public List<CulinaryProgramDTO> getAllCulinaryProgram() {
        List<CulinaryPrograms> allCulinaryProgram = culinaryProgramDAO.getAllCulinaryProgram();
        List<CulinaryProgramDTO> allCulinaryProgramDTO = new ArrayList<>();

        for (CulinaryPrograms program : allCulinaryProgram) {
            allCulinaryProgramDTO.add(new CulinaryProgramDTO(program.getProgramId(), program.getProgramName(), program.getDuration(), program.getFees(), program.getEnrollments()));
        }
        return allCulinaryProgramDTO;
    }

    @Override
    public void saveProgram(String studentId, String programName, double installment) {
        Student student = studentDAO.getStudent(studentId);
        CulinaryPrograms culinaryProgram = culinaryProgramDAO.getProgramsCheckName(programName);
        Enrollment enrollment = new Enrollment(installment,culinaryProgram.getFees()-installment,student,culinaryProgram);
        enrollmentDAO.save(enrollment);
    }
}
