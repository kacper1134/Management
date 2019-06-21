package company.exception;

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
