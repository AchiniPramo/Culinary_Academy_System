package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CulinaryProgramDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.db.FactoryConfiguration;
import lk.ijse.dto.CulinaryProgramDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.CulinaryProgram;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAO(DAOFactory.DAOType.STUDENT);
    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public void deleteStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getTel(),studentDTO.getRegistrationDate(),studentDTO.getEnrollments());
        studentDAO.deleteStudent(student);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getTel(),studentDTO.getRegistrationDate(),studentDTO.getEnrollments());
        studentDAO.updateStudent(student);
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> allStudent = studentDAO.getAllStudent();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : allStudent) {
            studentDTOS.add(new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getTel(),student.getRegistrationDate(),student.getEnrollments()));
        }
        return studentDTOS;
    }

    @Override
    public List<CulinaryProgramDTO> getAllCulinaryProgram() {
        List<CulinaryProgram> allCulinaryProgram = culinaryProgramDAO.getAllCulinaryProgram();
        List<CulinaryProgramDTO> allCulinaryProgramDTO = new ArrayList<>();

        for (CulinaryProgram culinaryProgram : allCulinaryProgram) {
            allCulinaryProgramDTO.add(new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFee(), culinaryProgram.getEnrollments()));
        }
        return allCulinaryProgramDTO;
    }

    @Override
    public void saveStudentWithProgram(StudentDTO object, String programName, double installment) {
        Student student = new Student(object.getStudentId(), object.getName(), object.getAddress(), object.getTel(), object.getRegistrationDate(), object.getEnrollments());
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(student);

            CulinaryProgram programsCheckName = culinaryProgramDAO.getProgramsCheckName(programName.trim());

            Enrollment enrollment = new Enrollment(installment,programsCheckName.getFee() - installment,student,programsCheckName);
            session.save(enrollment);

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public StudentDTO getStudent(String studentId){
        Student student = studentDAO.getStudent(studentId);
        return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getTel(),student.getRegistrationDate(),student.getEnrollments());
    }
}
