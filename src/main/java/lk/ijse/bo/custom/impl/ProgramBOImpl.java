package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CulinaryProgramDAO;
import lk.ijse.dto.CulinaryProgramDTO;
import lk.ijse.entity.CulinaryProgram;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public void saveCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryProgram culinaryProgram = new CulinaryProgram(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.saveCulinaryProgram(culinaryProgram);
    }

    @Override
    public void deleteCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryProgram culinaryProgram = new CulinaryProgram(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.deleteCulinaryProgram(culinaryProgram);
    }

    @Override
    public void updateCulinaryProgram(CulinaryProgramDTO culinaryProgramDTO) {
        CulinaryProgram culinaryProgram = new CulinaryProgram(culinaryProgramDTO.getProgramId(), culinaryProgramDTO.getProgramName(), culinaryProgramDTO.getDuration(), culinaryProgramDTO.getFee(), culinaryProgramDTO.getEnrollments());
        culinaryProgramDAO.updateCulinaryProgram(culinaryProgram);
    }

    @Override
    public List<CulinaryProgramDTO> getAllCulinaryProgram() {
        List<CulinaryProgram> allCulinaryProgram = culinaryProgramDAO.getAllCulinaryProgram();
        List<CulinaryProgramDTO> allCulinaryProgramDTO = new ArrayList<>();

        for (CulinaryProgram culinaryProgram : allCulinaryProgram) {
            allCulinaryProgramDTO.add(new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFee(), culinaryProgram.getEnrollments()));
        }
        return allCulinaryProgramDTO;
    }

    @Override
    public CulinaryProgramDTO getCulinaryProgram(String programId){
        CulinaryProgram culinaryProgram = culinaryProgramDAO.getCulinaryProgram(programId);
        if (culinaryProgram == null){
            return null;
        }
        return new CulinaryProgramDTO(culinaryProgram.getProgramId(), culinaryProgram.getProgramName(), culinaryProgram.getDuration(), culinaryProgram.getFee(), culinaryProgram.getEnrollments());
    }
}
