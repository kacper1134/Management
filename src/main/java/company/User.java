package company;

public class User
{
    private Long id;
    private String login;
    private String password;
    public static final String USER_SEPARATOR = "#";

    public User(long id, String login, String password)
    {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString()
    {
        return id + "#" + login + "#" + password;
    }
}
