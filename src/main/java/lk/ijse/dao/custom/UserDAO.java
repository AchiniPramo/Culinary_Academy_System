package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.User;
import lk.ijse.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserDAO extends SuperDAO {

    void save(User user) throws UserAlreadyExistsException;
    void update(User user);
    void delete(User user);
    User getUser(String userName);
    List<User> getAllUsers();
}
