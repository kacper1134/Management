package company.validator;

import company.User;
import company.dao.api.UserDao;
import company.dao.UserDaoImpl;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;

import java.io.IOException;


public class UserValidator
{
    private static UserValidator userValidator = null;
    private final int MINIMUM_LENGTH_PASSWORD = 6;
    private final int MINIMUM_LENGTH_LOGIN = 4;

    private UserValidator()
    {

    }

    public static UserValidator getInstance()
    {
        if(userValidator == null)
        {
            userValidator = new UserValidator();
        }

        return userValidator;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginExceotion
    {
        if(!isPasswordLengthEnough(user.getPassword()))
        {
            throw new UserShortLengthPasswordException(user.getPassword());
        }
        if(!isLoginLengthEnough(user.getLogin()))
        {
            throw new UserShortLengthLoginExceotion(user.getLogin());
        }
        return true;
    }

    private boolean isPasswordLengthEnough(String password)
    {
        return password.length() >= MINIMUM_LENGTH_PASSWORD;
    }

    private boolean isLoginLengthEnough(String login)
    {
        return login.length() >= MINIMUM_LENGTH_LOGIN;
    }

}
