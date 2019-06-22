package company.service.api;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService
{
    List<User> getAllUsers() throws IOException;
    boolean addUser(User user) throws IOException, UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException;
    void removeUserById(Long userId) throws IOException;
    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;
    boolean isCorrectLoginAndPassword(String login,String password) throws UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException;
    boolean isLoginAlreadyExist(String login) throws IOException, UserLoginAlreadyExistException;
}
