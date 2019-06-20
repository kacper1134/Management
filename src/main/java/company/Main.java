package company;

import company.dao.ProductDaoImpl;
import company.dao.UserDaoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException
    {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"admin","admin"));
        userList.add(new User(1,"admin","admin"));
        userList.add(new User(2,"admin","admin"));
        userList.add(new User(1,"admin","admin"));
        userList.add(new User(1,"admin","admin"));
        userList.add(new User(2,"admin","admin"));

        UserDaoImpl userDao = new UserDaoImpl("cos.txt");
        userDao.saveUsers(userList);
        userDao.saveUser(new User(3,"admin","admin"));
        System.out.println(userDao.getUserById(3L));
    }
}
