package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public interface DashboardBO extends SuperBO {

    Long getCulinaryProgramCount();
    Long getStudentCount();
    List<StudentDTO> getAllProgramStudents();
}
