package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;
import exeptions.InvalidCredentialsException;

public class LoginBOImpl implements LoginBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.DAOType.USER);
    @Override
    public UserDTO getUser(String userName) throws InvalidCredentialsException {
        try {
            User user = userDAO.getUser(userName);
            return new UserDTO(user.getUserId(),user.getUserName(),user.getPassword(),user.getRole());
        } catch (Exception e){
            throw new InvalidCredentialsException(e.getMessage());
        }

    }
}
