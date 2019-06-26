package company;

import company.enums.Color;
import company.enums.Material;
import company.enums.SkinType;
import company.facade.ProductFacadeImpl;
import company.facade.UserRegisterLoginFacadeImpl;
import company.parser.ColorParser;
import company.parser.MaterialParser;
import company.parser.SkinParser;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        int state = welcomMenu();

        while(state != 0)
        {
            int log_choice = loggedMenu();

            while(state == 2 && log_choice != 0)
            {
                if(log_choice == 1)
                {
                    productMenu();
                }
                else if(log_choice == 2)
                {
                    remove_Product();
                }
                else
                {
                    display_All_Products();
                }
                log_choice = loggedMenu();
            }

            state = welcomMenu();
        }
    }
    public static int welcomMenu() throws  SQLException, ClassNotFoundException {
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

                System.out.println(userRegisterLoginFacade.registerUser(new User(1L,login,hasło)));

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

    public static int loggedMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("2 - Usuń produkt");
        System.out.println("3 - Wyświetl dostępne produkty");
        System.out.println("Dowolny inna liczba - Wyloguj się");
        System.out.print("Twój wybór: ");

        int key = scanner.nextInt();

        switch(key)
        {
            case 1:
            {
                return 1;
            }
            case 2:
            {
                return 2;
            }
            case 3:
            {
                return 3;
            }
            default:
            {
                return 0;
            }
        }
    }
    public static void productMenu()
    {
        Scanner scanner = new Scanner(System.in);
        ProductFacadeImpl productFacade = ProductFacadeImpl.getInstance();

        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
        System.out.print("Twój wybór: ");
        int key = scanner.nextInt();

        switch(key)
        {
            case 1:
            {
                System.out.println("Podaj nazwę przedmiotu: ");
                String name = scanner.next();
                System.out.println("Podaj cenę produktu: ");
                Float price = scanner.nextFloat();
                System.out.println("Podaj wagę produktu: ");
                Float weight = scanner.nextFloat();
                System.out.println("Podaj kolor produktu(BLACK,WHITE,RED,GREEN,BLUE,YELLOW): ");
                Color color = ColorParser.strToColor(scanner.next().toUpperCase());
                System.out.println("Podaj ilość produktu: ");
                Integer count = scanner.nextInt();
                System.out.println("Podaj rozmiar buta: ");
                Integer size = scanner.nextInt();
                System.out.println("Podaj typ skóry (NATURAL,ARTIFICIAL): ");
                SkinType skinType = SkinParser.strToSkinType(scanner.next().toUpperCase());

                productFacade.createProduct(new Boots(1,name,price,weight,color,count,size,skinType));
                break;
            }
            case 2:
            {
                System.out.println("Podaj nazwę przedmiotu: ");
                String name = scanner.next();
                System.out.println("Podaj cenę produktu: ");
                Float price = scanner.nextFloat();
                System.out.println("Podaj wagę produktu: ");
                Float weight = scanner.nextFloat();
                System.out.println("Podaj kolor produktu(BLACK,WHITE,RED,GREEN,BLUE,YELLOW): ");
                Color color = ColorParser.strToColor(scanner.next().toUpperCase());
                System.out.println("Podaj ilość produktu: ");
                Integer count = scanner.nextInt();
                System.out.println("Podaj rozmiar ubrania: ");
                String size = scanner.next();
                System.out.println("Podaj materiał z którego jest zrobione ubranie(LEATHER,FUR,COTTON,WOOL,POLYESTERS): ");
                Material material = MaterialParser.strToMaterial(scanner.next().toUpperCase());

                productFacade.createProduct(new Cloth(1,name,price,weight,color,count,size,material));
                break;
            }
            case 3:
            {
                System.out.println("Podaj nazwę przedmiotu: ");
                String name = scanner.next();
                System.out.println("Podaj cenę produktu: ");
                Float price = scanner.nextFloat();
                System.out.println("Podaj wagę produktu: ");
                Float weight = scanner.nextFloat();
                System.out.println("Podaj kolor produktu(BLACK,WHITE,RED,GREEN,BLUE,YELLOW): ");
                Color color = ColorParser.strToColor(scanner.next().toUpperCase());
                System.out.println("Podaj ilość produktu: ");
                Integer count = scanner.nextInt();

                productFacade.createProduct(new Product(1,name,price,weight,color,count));
                break;
            }
            default:
            {
                System.out.println("Błędna opcja!!!!");
            }
        }
    }
    public static void remove_Product()
    {
        ProductFacadeImpl productFacade = ProductFacadeImpl.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę produktu do usunięcia: ");
        String name = scanner.next();

        productFacade.removeProduct(name);
    }
    public static void display_All_Products()
    {
        ProductFacadeImpl productFacade = ProductFacadeImpl.getInstance();
        List<Product> productList = productFacade.getAllProducts();


        for(Product product : productList)
        {
            System.out.println(product.toString());
        }
    }
}
