package company.service.api;

import company.User;

import java.io.IOException;
import java.util.List;

public interface UserService
{
    List<User> getAllUsers() throws IOException;
    void addUser(User user) throws IOException;
    void removeUserById(Long userId) throws IOException;
}
