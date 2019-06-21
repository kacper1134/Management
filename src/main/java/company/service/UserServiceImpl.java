package company.service;

import company.User;
import company.dao.UserDao;
import company.dao.UserDaoImpl;
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
    public void addUser(User user) throws IOException
    {
        userDao.saveUser(user);
    }
    @Override
    public void removeUserById(Long userId) throws IOException
    {
        userDao.removeUserById(userId);
    }
}
