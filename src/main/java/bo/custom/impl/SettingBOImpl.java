package bo.custom.impl;


import bo.custom.SettingBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class SettingBOImpl implements SettingBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.DAOType.USER);

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> allUsers = userDAO.getAllUsers();

        for (User user : allUsers) {
            userDTOS.add(new UserDTO(user.getUserId(), user.getUserName(), user.getPassword(), user.getRole()));
        }
        return userDTOS;
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getRole());
        userDAO.delete(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getRole());
        userDAO.update(user);
    }
}
