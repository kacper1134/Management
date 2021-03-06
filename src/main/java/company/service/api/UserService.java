package company.service.api;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserService
{
    List<User> getAllUsers() throws IOException, SQLException;
    boolean addUser(User user) throws IOException, UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException, SQLException;
    void removeUserById(Long userId) throws IOException, SQLException;
    User getUserById(Long userId) throws IOException, SQLException;
    User getUserByLogin(String login) throws IOException, SQLException;
    boolean isCorrectLoginAndPassword(String login,String password) throws UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException, IOException, SQLException;
    boolean isLoginAlreadyExist(String login) throws IOException, UserLoginAlreadyExistException, SQLException;
}
