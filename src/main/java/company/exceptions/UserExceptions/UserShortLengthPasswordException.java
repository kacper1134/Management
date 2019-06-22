package company.exceptions.UserExceptions;

public class UserShortLengthPasswordException extends Exception
{
    public UserShortLengthPasswordException(String password)
    {
        super("Hasło : " + password + " jest za krótkie");
    }
    public UserShortLengthPasswordException()
    {

    }
}
