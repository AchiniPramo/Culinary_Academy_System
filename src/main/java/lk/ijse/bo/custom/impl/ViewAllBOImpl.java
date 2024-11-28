package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ViewAllBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CulinaryProgramDAO;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.CulinaryProgramDTO;
import lk.ijse.entity.CulinaryProgram;

import java.util.ArrayList;
import java.util.List;

public class ViewAllBOImpl implements ViewAllBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAO(DAOFactory.DAOType.QUERY);

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
    public List<Object[]> getAllEqualByProgramName(String programName){
        return queryDAO.getAllEqualByProgramName(programName);
    }
}
