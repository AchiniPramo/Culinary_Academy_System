package dao.custom;

import dao.SuperDao;
import entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDao {
    void saveStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);
    List<Student> getAllStudent();
    Student getStudent(String studentId);
    Long getStudentCount();
}
