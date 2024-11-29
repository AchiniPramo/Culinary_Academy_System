package bo.custom;


import bo.SuperBO;
import dto.CulinaryProgramDTO;

import java.util.List;

public interface ViewBO extends SuperBO {

    List<CulinaryProgramDTO> getAllCulinaryProgram();
    List<Object[]> getAllEqualByProgramName(String programName);
}
