package bo.custom;


import bo.SuperBO;
import dto.UserDTO;
import exeptions.UserAlreadyExistsException;

public interface SignUpBO  extends SuperBO {

    void signUp(UserDTO userDTO) throws UserAlreadyExistsException;
}
