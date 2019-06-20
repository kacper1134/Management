package company.dao;

import company.User;

import java.util.List;

public interface UserDao
{
    void saveUser(User user);
    void saveUsers(List<User> users);
    List<User> getAllUsers();
    User getUserByLogin(String login);
    User getuserById(Long userId);
    void removeUserById(String login);
    void removeUserById(Long id);
}
