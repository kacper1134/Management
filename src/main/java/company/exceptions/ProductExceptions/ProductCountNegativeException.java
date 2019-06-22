package company.exceptions.ProductExceptions;

public class ProductCountNegativeException extends Exception
{
    public ProductCountNegativeException()
    {

    }

    public ProductCountNegativeException(String message)
    {
        super(message);
    }
}
