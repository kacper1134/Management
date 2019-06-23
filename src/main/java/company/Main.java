package company;

import company.enums.Color;
import company.enums.Material;
import company.enums.SkinType;
import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.facade.UserRegisterLoginFacadeImpl;
import company.service.ProductServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws UserShortLengthLoginExceotion, UserLoginAlreadyExistException, UserShortLengthPasswordException, IOException
    {
        int state = welcomMenu();

        while(state != 0)
        {
            while(state == 2 && loggedMenu())
            {
                productMenu();
            }

            state = welcomMenu();
        }
    }
    public static int welcomMenu() throws IOException, UserShortLengthLoginExceotion, UserLoginAlreadyExistException, UserShortLengthPasswordException
    {
        UserRegisterLoginFacadeImpl userRegisterLoginFacade = UserRegisterLoginFacadeImpl.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zerejestruj się");
        System.out.println("0 - Wyjdź");
        System.out.print("Twój wybór: ");
        int key = scanner.nextInt();

        switch (key)
        {
            case 1:
            {
                System.out.println("Wprowadź login: ");
                String login = scanner.next();
                System.out.println("Wprowadź hasło: ");
                String hasło = scanner.next();

                if(userRegisterLoginFacade.loginUser(login,hasło))
                {
                    System.out.println("Udało ci się zalogować!!!");
                    return 2;
                }
                else
                {
                    System.out.println("Niepoprawy login lub hasło prosimy spróbować ponownie");
                    return 1;
                }

            }
            case 2:
            {
                System.out.println("Wprowadź login: ");
                String login = scanner.next();
                System.out.println("Wprowadź hasło: ");
                String hasło = scanner.next();

                if(userRegisterLoginFacade.registerUser(new User(1L,login,hasło)))
                {
                    System.out.println("Udało ci się zajerestrować!!!");
                }
                else
                {
                    System.out.println("Nie udało ci się zajerestrować");
                }
                return 1;

            }
            case 0:
            {
                return 0;
            }
            default:
            {
                return 1;
            }
        }
    }
    public static boolean loggedMenu() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("0 - Wyloguj się");
        System.out.print("Twój wybór: ");
        int key = scanner.nextInt();
        switch(key)
        {
            case 1:
            {
                return true;
            }
            case 0:
            {
                return false;
            }
            default:
            {
                return true;
            }
        }
    }
    public static void productMenu() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
        System.out.print("Twój wybór: ");
        int key = scanner.nextInt();

        switch(key)
        {
            case 1:
            {
                productService.saveProduct(new Boots(1,"Boots",1.2f,1.3f, Color.BLUE,1,40, SkinType.NATURAL));
                break;
            }
            case 2:
            {
                productService.saveProduct(new Cloth(1,"Cloth",1.2f,1.3f,Color.RED,1,"S", Material.LEATHER));
                break;
            }
            case 3:
            {
                productService.saveProduct(new Product(1,"Product",1.2f,1.3f,Color.YELLOW,1));
                break;
            }
            default:
            {
                System.out.println("Błędna opcja!!!!");
            }
        }
    }
}
