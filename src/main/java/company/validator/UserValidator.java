package company.validator;

import company.User;
import company.dao.UserDao;
import company.dao.UserDaoImpl;
import company.exception.UserLoginAlreadyExistException;
import company.exception.UserShortLengthLoginExceotion;
import company.exception.UserShortLengthPasswordException;

import java.io.IOException;


public class UserValidator
{
    private static UserValidator userValidator = null;
    private final int MINIMUM_LENGTH_PASSWORD = 6;
    private final int MINIMUM_LENGTH_LOGIN = 4;
    private UserDao userDao = UserDaoImpl.getInstance();

    private UserValidator() throws IOException
    {

    }

    public static UserValidator getInstance() throws IOException
    {
        if(userValidator == null)
        {
            userValidator = new UserValidator();
        }

        return userValidator;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginExceotion, UserLoginAlreadyExistException
    {
        if(!isPasswordLengthEnough(user.getPassword()))
        {
            throw new UserShortLengthPasswordException(user.getPassword());
        }
        if(!isLoginLegthEnough(user.getLogin()))
        {
            throw new UserShortLengthLoginExceotion(user.getLogin());
        }
        if(!isLoginAlreadyExist(user.getLogin()))
        {
            throw new UserLoginAlreadyExistException(user.getLogin());
        }
        return true;
    }

    private boolean isPasswordLengthEnough(String password)
    {
        return password.length() >= MINIMUM_LENGTH_PASSWORD;
    }

    private boolean isLoginLegthEnough(String login)
    {
        return login.length() >= MINIMUM_LENGTH_LOGIN;
    }

    private boolean isLoginAlreadyExist(String login)
    {
        User user = null;
        try
        {
            user = userDao.getUserByLogin(login);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        if(user == null)
        {
            return false;
        }

        return true;
    }
}
