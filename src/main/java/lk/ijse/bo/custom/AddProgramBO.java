package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CulinaryProgramDTO;

import java.util.List;

public interface AddProgramBO extends SuperBO {

    List<CulinaryProgramDTO> getAllCulinaryProgram();
    void saveProgram(String studentId,String programName,double installment);
}
