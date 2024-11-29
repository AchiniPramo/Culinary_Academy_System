package bo.custom.impl;


import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dao.custom.StudentDAO;
import db.FactoryConfiguration;
import dto.CulinaryProgramDTO;
import dto.StudentDTO;
import entity.CulinaryPrograms;
import entity.Enrollment;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl  implements StudentBO {

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
        List<CulinaryPrograms> allCulinaryProgram = culinaryProgramDAO.getAllCulinaryProgram();
        List<CulinaryProgramDTO> allCulinaryProgramDTO = new ArrayList<>();

        for (CulinaryPrograms culinaryProgram : allCulinaryProgram) {
            allCulinaryProgramDTO.add(new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFees(), culinaryProgram.getEnrollments()));
        }
        return allCulinaryProgramDTO;
    }

    @Override
    public void saveStudentWithProgram(StudentDTO object, String value, double v) {
        Student student = new Student(object.getStudentId(), object.getName(), object.getAddress(), object.getTel(), object.getRegistrationDate(), object.getEnrollments());
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(student);

            CulinaryPrograms programsCheckName = culinaryProgramDAO.getProgramsCheckName(value.trim());

            Enrollment enrollment = new Enrollment(v,programsCheckName.getFees() - v,student,programsCheckName);
            session.save(enrollment);

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public StudentDTO getStudent(String studentId) {
        Student student = studentDAO.getStudent(studentId);
        return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getTel(),student.getRegistrationDate(),student.getEnrollments());
    }
}
