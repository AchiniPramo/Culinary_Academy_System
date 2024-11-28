package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SignUpBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.exception.UserAlreadyExistsException;

public class SignUpBOImpl implements SignUpBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.DAOType.USER);

    @Override
    public void signUp(UserDTO userDTO) throws UserAlreadyExistsException {
        User user = new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.getRole());
        userDAO.save(user);
    }
}
