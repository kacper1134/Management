package company;

import company.exceptions.UserExceptions.UserLoginAlreadyExistException;
import company.exceptions.UserExceptions.UserShortLengthLoginExceotion;
import company.exceptions.UserExceptions.UserShortLengthPasswordException;
import company.service.ProductServiceImpl;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, UserShortLengthLoginExceotion, UserShortLengthPasswordException, UserLoginAlreadyExistException
    {
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
    }
}
