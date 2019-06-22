package company.exceptions.ProductExceptions;

public class ProductNameEmptyException extends Exception
{
    public ProductNameEmptyException()
    {
    }

    public ProductNameEmptyException(String message)
    {
        super(message);
    }
}
