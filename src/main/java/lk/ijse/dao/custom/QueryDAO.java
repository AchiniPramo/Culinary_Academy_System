package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<Student> getAllProgramsStudent();
    List<Object[]> getAllEqualByProgramName(String programName);
}
