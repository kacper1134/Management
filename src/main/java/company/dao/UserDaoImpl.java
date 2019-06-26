package company.dao;

import company.User;
import company.dao.api.UserDao;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.parser.UserParser;
import company.validator.UserValidator;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao
{
    private static UserDaoImpl userDao = null;
    private Connection connection;
    private String databaseName = "management";
    private String tableName = "users";
    private String user = "root";
    private String password = "admin";

    private UserDaoImpl()throws SQLException, ClassNotFoundException
    {
        init();
    }

    private void init() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                +databaseName+"?serverTimezone=UTC",user,password);
    }

    public static UserDaoImpl getInstance() throws SQLException, ClassNotFoundException
    {
        if(userDao == null)
        {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public void saveUser(User user) throws SQLException, UserShortLengthPasswordException, UserShortLengthLoginExceotion
    {
        if(UserValidator.getInstance().isValidate(user))
        {
            PreparedStatement statement;

            String query = "insert into " + tableName + "(login,password) values(?,?)";

            statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
            statement.close();
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException
    {
        Statement statement = null;

        List<User> users = new LinkedList<>();

        String query = "select * from " + tableName;

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next())
        {
            Integer id = resultSet.getInt("ID");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            User user = new User(id,login,password);

            users.add(user);
        }
        statement.close();
        return users;
    }

    @Override
    public void removeUserByLogin(String login) throws SQLException
    {
        PreparedStatement statement;

        String query = "delete from " + tableName + " where login = \"" + login + "\"";

        statement = connection.prepareStatement(query);

        statement.execute();
        statement.close();
    }

    @Override
    public void removeUserById(Long id) throws SQLException {
        PreparedStatement statement;

        String query = "delete from " + tableName + " where id = " + id;

        statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
    }

    @Override
    public void updateUser(User user) throws SQLException, UserShortLengthPasswordException, UserShortLengthLoginExceotion
    {
        if(UserValidator.getInstance().isValidate(user))
        {
            PreparedStatement statement;

            String query = "update " + tableName + " set login = ?,password = ? where id = " + user.getId();

            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
            statement.close();
        }
    }
}
