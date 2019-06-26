package company.dao.api;

import company.User;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao
{
    List<User> getAllUsers() throws SQLException;
    void removeUserByLogin(String login) throws SQLException;
    void removeUserById(Long id) throws SQLException;
    void saveUser(User user) throws SQLException,  UserShortLengthPasswordException, UserShortLengthLoginExceotion;
    void updateUser(User user) throws SQLException,  UserShortLengthPasswordException, UserShortLengthLoginExceotion;

}
