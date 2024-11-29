package bo.custom;


import bo.SuperBO;
import dto.CulinaryProgramDTO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO  extends SuperBO {
    void deleteStudent(StudentDTO studentDTO);
    void updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudent();
    List<CulinaryProgramDTO> getAllCulinaryProgram();
    void saveStudentWithProgram(StudentDTO object, String value, double v);
    StudentDTO getStudent(String studentId);

}
