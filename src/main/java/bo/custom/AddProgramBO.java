package bo.custom;


import bo.SuperBO;
import dto.CulinaryProgramDTO;

import java.util.List;

public interface AddProgramBO extends SuperBO {


    List<CulinaryProgramDTO> getAllCulinaryProgram();
    void saveProgram(String studentId,String programName,double installment);
}
