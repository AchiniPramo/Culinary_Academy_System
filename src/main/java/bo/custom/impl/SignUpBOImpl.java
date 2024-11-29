package bo.custom.impl;


import bo.custom.SignUpBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;
import exeptions.UserAlreadyExistsException;

public class SignUpBOImpl implements SignUpBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.DAOType.USER);

    @Override
    public void signUp(UserDTO userDTO) throws UserAlreadyExistsException {
        User user = new User(userDTO.getUserName(),userDTO.getPassword(),userDTO.getRole());
        userDAO.save(user);
    }
}
