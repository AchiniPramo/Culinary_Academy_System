package dao.custom;

import dao.SuperDao;
import entity.CulinaryPrograms;

import java.util.List;

public interface CulinaryProgramDAO extends SuperDao {
    void saveCulinaryProgram(CulinaryPrograms culinaryPrograms);
    void deleteCulinaryProgram(CulinaryPrograms culinaryPrograms);
    void updateCulinaryProgram(CulinaryPrograms culinaryPrograms);
    List<CulinaryPrograms> getAllCulinaryProgram();
    CulinaryPrograms getProgramsCheckName(String programName);
    CulinaryPrograms getCulinaryProgram(String programId);
    Long getCulinaryProgramCount();
}
