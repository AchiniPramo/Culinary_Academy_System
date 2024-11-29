package dao.custom;

import dao.SuperDao;
import entity.User;
import exeptions.UserAlreadyExistsException;

import java.util.List;

public interface UserDAO extends SuperDao {
    void save(User user) throws UserAlreadyExistsException;
    void update(User user);
    void delete(User user);
    User getUser(String userName);
    List<User> getAllUsers();

}
