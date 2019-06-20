package company.dao;

import company.Product;
import company.parse.ProductParser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    private String fileName;
    private String productType;

    public ProductDaoImpl(String fileName,String productType)
    {
        this.fileName = fileName;

        this.productType = productType;
    }
    @Override
    public void SaveProduct(Product product) throws IOException
    {
        List<Product> products = getAllProducts();

        products.add(product);

        SaveProducts(products);
    }
    @Override
    public void SaveProducts(List<Product> products) throws FileNotFoundException
    {
        PrintWriter printWriter = new PrintWriter(fileName);

        for(Product product : products)
        {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }
    @Override
    public void removeProductById(Long productId) throws IOException
    {
        List<Product> products = getAllProducts();

        for(int i = products.size() - 1;i >= 0;i--)
        {
            boolean isFoundProduct = products.get(i).getId() == productId;

            if(isFoundProduct)
            {
                products.remove(i);
            }
        }
        SaveProducts(products);
    }
    @Override
    public void removeProductByName(String productName) throws IOException
    {
        List<Product> products = getAllProducts();

        for(int i = products.size() - 1;i >=0;i--)
        {
            boolean isFoundProduct = products.get(i).getProductName().equals(productName);

            if(isFoundProduct)
            {
                products.remove(i);
            }
        }
        SaveProducts(products);
    }
    @Override
    public List<Product> getAllProducts() throws IOException
    {
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Product> products = new ArrayList<>();

        String line = bufferedReader.readLine();

        while(line != null)
        {
            ProductParser parser = new ProductParser();

            products.add(parser.stringToProduct(line,productType));

            line = bufferedReader.readLine();

        }
        bufferedReader.close();

        return products;
    }
    @Override
    public Product getProductById(Long productId) throws IOException
    {
        List<Product> products = getAllProducts();

        for(int i = 0;i<products.size();i++)
        {
            boolean foundProduct = products.get(i).getId() == productId;
            if(foundProduct)
            {
                return products.get(i);
            }
        }
        return null;
    }
    @Override
    public Product getProductByProductName(String productName) throws IOException
    {
        List<Product> products = getAllProducts();

        for(int i = 0;i<products.size();i++)
        {
            boolean foundProduct = products.get(i).getProductName().equals(productName);
            if(foundProduct)
            {
                return products.get(i);
            }
        }
        return null;
    }
}
