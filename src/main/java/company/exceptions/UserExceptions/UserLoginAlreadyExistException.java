package company.exceptions.UserExceptions;

public class UserLoginAlreadyExistException extends Exception
{
    public UserLoginAlreadyExistException(String login)
    {
        super("Login + " + login + " jest zajęty prosimy o wybranie innej nazwy użytkownika");
    }
    public UserLoginAlreadyExistException()
    {

    }
}
