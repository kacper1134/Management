package company.facade;

import company.User;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.facade.api.UserRegisterLoginFacade;
import company.service.UserServiceImpl;
import java.sql.SQLException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade
{
    private static UserRegisterLoginFacadeImpl userRegisterLoginFacade = null;
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() throws SQLException, ClassNotFoundException {

    }

    public static UserRegisterLoginFacadeImpl getInstance() throws SQLException, ClassNotFoundException {
        if(userRegisterLoginFacade == null)
        {
            userRegisterLoginFacade = new UserRegisterLoginFacadeImpl();
        }

        return userRegisterLoginFacade;
    }

    @Override
    public String registerUser(User user)
    {
        try
        {
            userService.addUser(user);
        }
        catch (UserShortLengthLoginExceotion e)
        {
            return "Za krótka nazwa użytkownika";
        }
        catch (UserShortLengthPasswordException e)
        {
            return "Za krótkie hasło";
        }
        catch (UserLoginAlreadyExistException e)
        {
            return "Wybrana nazwa użytkownika jest zajęta";
        }
        catch (SQLException e)
        {
            return "Błąd przy pracy z bazą danych";
        }

        return "Utworzono konto użytkownika " + user.getLogin();
    }

    @Override
    public boolean loginUser(String login, String password)
    {
        try
        {
            if(userService.isCorrectLoginAndPassword(login,password))
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Nie udało ci się zalogować - błąd przy łączeniu z bazą danych");
            return false;
        }
        System.out.println("Błedna nazwa użytkownika lub hasło");
        return false;
    }
}
