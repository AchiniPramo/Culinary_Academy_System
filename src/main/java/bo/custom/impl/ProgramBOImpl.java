package bo.custom.impl;


import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dto.CulinaryProgramDTO;
import entity.CulinaryPrograms;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);


    @Override
    public void saveCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryPrograms culinaryProgram = new CulinaryPrograms(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.saveCulinaryProgram(culinaryProgram);
    }

    @Override
    public void deleteCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryPrograms culinaryProgram = new CulinaryPrograms(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.deleteCulinaryProgram(culinaryProgram);
    }

    @Override
    public void updateCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryPrograms culinaryProgram = new CulinaryPrograms(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.updateCulinaryProgram(culinaryProgram);
    }

    @Override
    public List<CulinaryProgramDTO> getAllCulinaryProgram() {
        List<CulinaryPrograms> allCulinaryProgram = culinaryProgramDAO.getAllCulinaryProgram();
        List<CulinaryProgramDTO> allCulinaryProgramDTO = new ArrayList<>();

        for (CulinaryPrograms culinaryProgram : allCulinaryProgram) {
            allCulinaryProgramDTO.add(new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFees(), culinaryProgram.getEnrollments()));
        }
        return allCulinaryProgramDTO;
    }

    @Override
    public CulinaryProgramDTO getCulinaryProgram(String programId) {
        CulinaryPrograms culinaryProgram = culinaryProgramDAO.getCulinaryProgram(programId);
        if (culinaryProgram == null){
            return null;
        }
        return new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFees(), culinaryProgram.getEnrollments());
    }
}
