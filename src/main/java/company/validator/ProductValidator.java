package company.validator;

import company.Product;
import company.exceptions.ProductExceptions.ProductCountNegativeException;
import company.exceptions.ProductExceptions.ProductNameEmptyException;
import company.exceptions.ProductExceptions.ProductPriceNoPositiveException;
import company.exceptions.ProductExceptions.ProductWeightNoPositiveException;

public class ProductValidator
{
    private static ProductValidator productValidator = null;

    public ProductValidator()
    {
    }

    public static ProductValidator getInstance()
    {
        if(productValidator == null)
        {
            productValidator = new ProductValidator();
        }

        return null;
    }

    public boolean isValidate(Product product) throws ProductNameEmptyException, ProductWeightNoPositiveException, ProductCountNegativeException, ProductPriceNoPositiveException
    {
        if(isPriceNoPositive(product.getPrice()))
        {
            throw new ProductPriceNoPositiveException("Product price is negative");
        }
        if(isCountNegatice(product.getProductCount()))
        {
            throw new ProductCountNegativeException("Product count is negative");
        }
        if(isWeightNoPositive(product.getWeight()))
        {
            throw new ProductWeightNoPositiveException("Product weight is no positive");
        }
        if(isNameEmpty(product.getProductName()))
        {
            throw new ProductNameEmptyException("Product name is empty");
        }
        return true;
    }

    private boolean isPriceNoPositive(float price)
    {
        return price <= 0;
    }
    private boolean isCountNegatice(int count)
    {
        return count < 0;
    }
    private boolean isWeightNoPositive(float weight)
    {
        return weight <= 0;
    }
    private boolean isNameEmpty(String name)
    {
        return name.length() == 0;
    }
}
