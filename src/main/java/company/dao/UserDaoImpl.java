package company.dao;

import company.User;

import java.util.List;

public class UserDaoImpl implements UserDao
{
    private String fileName;

    public UserDaoImpl(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void saveUser(User user)
    {

    }

    @Override
    public void saveUsers(List<User> users)
    {

    }

    @Override
    public List<User> getAllUsers()
    {
        return null;
    }

    @Override
    public User getUserByLogin(String login)
    {
        return null;
    }

    @Override
    public User getuserById(Long userId)
    {
        return null;
    }

    @Override
    public void removeUserById(String login)
    {

    }

    @Override
    public void removeUserById(Long id)
    {

    }
}
