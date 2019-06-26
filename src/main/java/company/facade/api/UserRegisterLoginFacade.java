package company.facade.api;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.sql.SQLException;

public interface UserRegisterLoginFacade
{
    String registerUser(User user) throws UserShortLengthLoginExceotion, UserLoginAlreadyExistException, UserShortLengthPasswordException, IOException, SQLException;
    boolean loginUser(String login,String password) throws IOException, SQLException;
}
