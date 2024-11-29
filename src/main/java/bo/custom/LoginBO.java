package bo.custom;


import bo.SuperBO;
import dto.UserDTO;
import exeptions.InvalidCredentialsException;

public interface LoginBO extends SuperBO {

    UserDTO getUser(String userName) throws InvalidCredentialsException;

}
