package company.facade.api;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;

public interface UserRegisterLoginFacade
{
    boolean registerUser(User user) throws UserShortLengthLoginExceotion, UserLoginAlreadyExistException, UserShortLengthPasswordException, IOException;
    boolean loginUser(String login,String password) throws IOException;
}
