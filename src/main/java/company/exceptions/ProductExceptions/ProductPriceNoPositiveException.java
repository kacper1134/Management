package company.exceptions.ProductExceptions;

public class ProductPriceNoPositiveException extends Exception
{
    public ProductPriceNoPositiveException()
    {
    }

    public ProductPriceNoPositiveException(String message)
    {
        super(message);
    }
}
