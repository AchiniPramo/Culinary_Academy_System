package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.exception.UserAlreadyExistsException;

public interface SignUpBO extends SuperBO {

    void signUp(UserDTO userDTO) throws UserAlreadyExistsException;
}
