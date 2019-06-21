package company.service.api;

import company.User;
import company.exception.UserLoginAlreadyExistException;
import company.exception.UserShortLengthLoginExceotion;
import company.exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService
{
    List<User> getAllUsers() throws IOException;
    void addUser(User user) throws IOException, UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException;
    void removeUserById(Long userId) throws IOException;
}
