package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CulinaryProgramDTO;

import java.util.List;

public interface ProgramBO extends SuperBO {

    void saveCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO);
    void deleteCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO);
    void updateCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO);
    List<CulinaryProgramDTO> getAllCulinaryProgram();
    CulinaryProgramDTO getCulinaryProgram(String programId);
}
