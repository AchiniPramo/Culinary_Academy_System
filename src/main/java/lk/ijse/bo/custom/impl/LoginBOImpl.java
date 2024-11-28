package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.LoginBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.exception.InvalidCredentialsException;

public class LoginBOImpl implements LoginBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.DAOType.USER);

    @Override
    public UserDTO getUser(String userName) throws InvalidCredentialsException {
        try {
            User user = userDAO.getUser(userName);
            return new UserDTO(user.getUserId(),user.getUserName(),user.getPassword(),user.getRole());
        } catch (Exception e) {
            throw new InvalidCredentialsException(e.getMessage());
        }
    }
}
