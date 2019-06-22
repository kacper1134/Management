package company.service;

import company.User;
import company.dao.api.UserDao;
import company.dao.UserDaoImpl;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.service.api.UserService;
import company.validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService
{
    private static UserServiceImpl userService = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() throws IOException
    {

    }
    public static UserServiceImpl getInstance() throws IOException
    {
        if(userService == null)
        {
            userService = new UserServiceImpl();
        }

        return userService;
    }

    @Override
    public List<User>getAllUsers() throws IOException
    {
        return userDao.getAllUsers();
    }
    @Override
    public boolean addUser(User user) throws IOException, UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException
    {
        if(userValidator.isValidate(user) && !isLoginAlreadyExist(user.getLogin()))
        {
            userDao.saveUser(user);
            return true;
        }
        return false;
    }
    @Override
    public void removeUserById(Long userId) throws IOException
    {
        userDao.removeUserById(userId);
    }

    @Override
    public User getUserById(Long userId) throws IOException
    {
        List<User> users = getAllUsers();

        for(User user : users)
        {
            boolean foundUser = user.getId() == userId;

            if(foundUser)
            {
                return user;
            }
        }

        return null;
    }

    @Override
    public User getUserByLogin(String login) throws IOException
    {
        List<User> users = userDao.getAllUsers();

        for(User user : users)
        {
            boolean foundUser = user.getLogin().equals(login);

            if(foundUser)
            {
                return user;
            }
        }

        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) throws UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException
    {
        return userValidator.isValidate(new User(1,login,password));
    }

    @Override
    public boolean isLoginAlreadyExist(String login) throws IOException, UserLoginAlreadyExistException
    {
        List<User> users = userDao.getAllUsers();

        for(User user : users)
        {
            boolean foundUser = user.getLogin().equals(login);

            if(foundUser)
            {
                throw new UserLoginAlreadyExistException(login);
            }
        }

        return false;
    }
}
