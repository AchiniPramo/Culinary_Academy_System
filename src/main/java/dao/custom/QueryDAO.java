package dao.custom;

import dao.SuperDao;
import entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDao {
    List<Student> getAllProgramsStudent();
    List<Object[]> getAllEqualByProgramName(String programName);
}
