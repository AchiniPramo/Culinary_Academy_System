package bo.custom;


import bo.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface DashboardBO extends SuperBO {

    Long getCulinaryProgramCount();
    Long getStudentCount();
    List<StudentDTO> getAllProgramStudents();
}
