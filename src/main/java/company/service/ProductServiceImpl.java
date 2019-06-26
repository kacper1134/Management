package company.service;

import company.Product;
import company.dao.api.ProductDao;
import company.dao.ProductDaoImpl;
import company.service.api.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService
{
    private static ProductServiceImpl productService = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();

    private ProductServiceImpl() throws IOException
    {

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
        List<Product> products = productDao.getAllProducts();

        for(Product product : products)
        {
            boolean foundProduct = product.getProductName().equals(productName);

            if(foundProduct)
            {
                return product;
            }
        }

        return null;
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

    @Override
    public boolean saveProduct(Product product) throws IOException
    {
        productDao.SaveProduct(product);
        return true;
    }

    @Override
    public Product getProductByProductId(int productId) throws IOException
    {
        List<Product> products = getAllProducts();

        for(Product product : products)
        {
            boolean foundProduct = product.getId() == productId;

            if(foundProduct)
            {
                return product;
            }
        }

        return null;
    }

    @Override
    public boolean removeProductByProductName(String productName) throws IOException
    {
        productDao.removeProductByName(productName);
        return true;
    }
}
