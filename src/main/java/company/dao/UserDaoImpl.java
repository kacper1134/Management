package company.dao;

import company.User;
import company.dao.api.UserDao;
import company.parser.UserParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao
{
    private final String fileName = "Users.data";
    private static UserDaoImpl userDao = null;

    private UserDaoImpl() throws IOException
    {
        File file = new File(fileName);
        file.createNewFile();
    }

    public static UserDaoImpl getInstance() throws IOException
    {
        if(userDao == null)
        {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public void saveUser(User user) throws IOException
    {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException
    {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName,false));

        for(User user : users)
        {
            printWriter.write(user.toString() + "\n");
        }

        printWriter.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException
    {
        List<User> users = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        UserParser userParser = new UserParser();

        String line = bufferedReader.readLine();

        while(line != null)
        {
            users.add(userParser.stringToUser(line));
            line = bufferedReader.readLine();
        }

        return users;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException
    {
        List<User> users = getAllUsers();

        for(int i = users.size() - 1;i>=0;i--)
        {
            boolean foundUser = users.get(i).getLogin().equals(login);

            if(foundUser)
            {
                users.remove(i);
            }
        }

        saveUsers(users);
    }

    @Override
    public void removeUserById(Long id) throws IOException
    {
        List<User> users = getAllUsers();

        for(int i = users.size() - 1;i>=0;i--)
        {
            boolean foundUser = users.get(i).getId() == id;

            if(foundUser)
            {
                users.remove(i);
            }
        }

        saveUsers(users);
    }
}
