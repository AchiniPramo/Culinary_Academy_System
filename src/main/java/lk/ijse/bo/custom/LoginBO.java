package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.exception.InvalidCredentialsException;

public interface LoginBO extends SuperBO {

    UserDTO getUser(String userName) throws InvalidCredentialsException;
}
