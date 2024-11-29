package bo.custom;


import bo.SuperBO;
import dto.UserDTO;

import java.util.List;

public interface SettingBO  extends SuperBO {
    List<UserDTO> getAllUsers();
    void deleteUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
}
