package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO {

    void saveStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);
    List<Student> getAllStudent();
    Student getStudent(String studentId);
    Long getStudentCount();
}
