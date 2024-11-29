package bo.custom.impl;


import bo.custom.ViewBO;
import dao.DAOFactory;
import dao.custom.CulinaryProgramDAO;
import dao.custom.QueryDAO;
import dto.CulinaryProgramDTO;
import entity.CulinaryPrograms;

import java.util.ArrayList;
import java.util.List;

public class ViewBOImpl implements ViewBO {

    CulinaryProgramDAO culinaryProgramDAO = (CulinaryProgramDAO) DAOFactory.getDAO(DAOFactory.DAOType.PROGRAM);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAO(DAOFactory.DAOType.QUERY);
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
    public List<Object[]> getAllEqualByProgramName(String programName) {
        return queryDAO.getAllEqualByProgramName(programName);
    }
}
