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
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService
{
    private static UserServiceImpl userService = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() throws SQLException, ClassNotFoundException {

    }
    public static UserServiceImpl getInstance() throws  SQLException, ClassNotFoundException
    {
        if(userService == null)
        {
            userService = new UserServiceImpl();
        }

        return userService;
    }

    @Override
    public List<User>getAllUsers() throws  SQLException {
        return userDao.getAllUsers();
    }
    @Override
    public boolean addUser(User user) throws UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException, SQLException {
        if(userValidator.isValidate(user) && !isLoginAlreadyExist(user.getLogin()))
        {
            userDao.saveUser(user);
            return true;
        }
        return false;
    }
    @Override
    public void removeUserById(Long userId) throws  SQLException {
        userDao.removeUserById(userId);
    }

    @Override
    public User getUserById(Long userId) throws SQLException {
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
    public User getUserByLogin(String login) throws  SQLException {
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
    public boolean isCorrectLoginAndPassword(String login, String password) throws  SQLException {
        User user = getUserByLogin(login);

        if(user == null)
        {
            return false;
        }

        if(user.getPassword().equals(password))
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean isLoginAlreadyExist(String login) throws  UserLoginAlreadyExistException, SQLException {
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
