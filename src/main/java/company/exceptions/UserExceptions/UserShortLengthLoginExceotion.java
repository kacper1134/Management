package company.exceptions.UserExceptions;

public class UserShortLengthLoginExceotion extends Exception
{
    public UserShortLengthLoginExceotion(String login)
    {
        super("Login : " + login + " jest za krótki");
    }

    public UserShortLengthLoginExceotion()
    {

    }
}
