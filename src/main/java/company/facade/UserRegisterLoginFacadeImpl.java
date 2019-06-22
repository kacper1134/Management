package company.facade;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.facade.api.UserRegisterLoginFacade;
import company.service.UserServiceImpl;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade
{
    private static UserRegisterLoginFacadeImpl userRegisterLoginFacade = null;
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() throws IOException {

    }

    public static UserRegisterLoginFacadeImpl getInstance() throws IOException
    {
        if(userRegisterLoginFacade == null)
        {
            userRegisterLoginFacade = new UserRegisterLoginFacadeImpl();
        }

        return userRegisterLoginFacade;
    }

    @Override
    public boolean registerUser(User user) throws UserShortLengthLoginExceotion, UserLoginAlreadyExistException, UserShortLengthPasswordException, IOException
    {
        return userService.addUser(user);
    }

    @Override
    public boolean loginUser(String login, String password) throws IOException
    {
        if(userService.isCorrectLoginAndPassword(login,password))
        {
            return true;
        }
        return false;
    }
}
