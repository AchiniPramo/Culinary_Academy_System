package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;

import java.util.List;

public interface SettingBO extends SuperBO {

    List<UserDTO> getAllUsers();
    void deleteUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
}
