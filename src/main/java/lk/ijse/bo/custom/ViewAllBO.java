package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CulinaryProgramDTO;

import java.util.List;

public interface ViewAllBO extends SuperBO {

    List<CulinaryProgramDTO> getAllCulinaryProgram();
    List<Object[]> getAllEqualByProgramName(String programName);
}
