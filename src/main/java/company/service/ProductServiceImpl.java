package company.service;

import company.Product;
import company.dao.ProductDao;
import company.dao.ProductDaoImpl;
import company.service.api.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService
{
    private static ProductServiceImpl productService = null;
    private ProductDao productDao = new ProductDaoImpl("products.txt","PRODUCT");

    private ProductServiceImpl() throws IOException {

    }

    public static ProductServiceImpl getInstance() throws IOException
    {
        if(productService == null)
        {
            productService = new ProductServiceImpl();
        }

        return productService;
    }

    @Override
    public List<Product> getAllProducts() throws IOException
    {
        return productDao.getAllProducts();
    }

    @Override
    public Integer getCountProducts() throws IOException
    {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException
    {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductOnWarehouse(String productName) throws IOException
    {
        for(Product product : getAllProducts())
        {
            if(isProductExist(productName) && product.getProductCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) throws IOException
    {
        for(Product product : getAllProducts())
        {
            if(product.getProductName() == productName)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(Long productId) throws IOException
    {
        for(Product product : getAllProducts())
        {
            if(product.getId() == productId)
            {
                return true;
            }
        }
        return false;
    }
}
