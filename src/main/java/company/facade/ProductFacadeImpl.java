package company.facade;

import company.Product;
import company.facade.api.ProductFacade;
import company.service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade
{
    private static ProductFacadeImpl productFacade = null;
    private ProductServiceImpl productService;
    {
        try
        {
            productService = ProductServiceImpl.getInstance();
        }
        catch (IOException e)
        {
            System.out.println("Błąd przy odczycie danych z pliku");
        }
    }

    private ProductFacadeImpl()  {
    }

    public static ProductFacadeImpl getInstance()
    {
        if(productFacade == null)
        {
            productFacade = new ProductFacadeImpl();
        }
        return productFacade;
    }


    @Override
    public String createProduct(Product product)
    {
        try
        {
            productService.saveProduct(product);
        }
        catch (IOException e)
        {
            return "Błąd przy odczycie z pliku";
        }

        return "Udało się stworzyć produkt";
    }

    @Override
    public String removeProduct(String productName)
    {
        try
        {
            productService.removeProductByProductName(productName);
        }
        catch (IOException e)
        {
            return "Błąd odczytu z pliku";
        }
        return "Udało się usunąć produkt";
    }

    @Override
    public List<Product> getAllProducts()
    {
        try
        {
            return productService.getAllProducts();
        }
        catch (IOException e)
        {
            System.out.println("Nie udało się połączyć z plikiem");
            return null;
        }
    }
}
