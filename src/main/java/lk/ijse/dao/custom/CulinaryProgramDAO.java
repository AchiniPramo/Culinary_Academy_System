package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.CulinaryProgram;

import java.util.List;

public interface CulinaryProgramDAO extends SuperDAO {

    void saveCulinaryProgram(CulinaryProgram culinaryProgram);
    void deleteCulinaryProgram(CulinaryProgram culinaryProgram);
    void updateCulinaryProgram(CulinaryProgram culinaryProgram);
    List<CulinaryProgram> getAllCulinaryProgram();
    CulinaryProgram getProgramsCheckName(String programName);
    CulinaryProgram getCulinaryProgram(String programId);
    Long getCulinaryProgramCount();
}
