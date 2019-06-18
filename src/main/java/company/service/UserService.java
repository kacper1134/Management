package company.service;

import company.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(Long userId);
}
