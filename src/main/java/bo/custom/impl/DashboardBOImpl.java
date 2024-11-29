package bo.custom.impl;


import bo.custom.DashboardBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dao.custom.QueryDAO;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DashboardBOImpl implements DashboardBO {
    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAO(DAOFactory.DAOType.STUDENT);
//    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAO(DAOFactory.DAOType.QUERY);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAO(DAOFactory.DAOType.QUERY);

    @Override
    public Long getCulinaryProgramCount() {
        return culinaryProgramDAO.getCulinaryProgramCount();
    }

    @Override
    public Long getStudentCount() {
        return studentDAO.getStudentCount();
    }

    @Override
    public List<StudentDTO> getAllProgramStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> allProgramsStudent = queryDAO.getAllProgramsStudent();

        for (Student student : allProgramsStudent) {
            studentDTOS.add(new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getTel(),student.getRegistrationDate(),student.getEnrollments()));
        }
        return studentDTOS;
    }
}
