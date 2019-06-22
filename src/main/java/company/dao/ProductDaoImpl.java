package company.dao;

import company.Product;
import company.dao.api.ProductDao;
import company.parser.ProductParser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    private String fileName;
    private static ProductDaoImpl productDao = null;

    private ProductDaoImpl(String fileName) throws IOException
    {
        this.fileName = fileName;
        File file = new File(fileName);
        file.createNewFile();
    }
    public static ProductDaoImpl getInstance() throws IOException
    {
        if(productDao == null)
        {
            productDao = new ProductDaoImpl("Produkty.txt");
        }

        return productDao;
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
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName,false));

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
        ProductParser parser = new ProductParser();

        String line = bufferedReader.readLine();

        while(line != null)
        {
            products.add(parser.stringToProduct(line));

            line = bufferedReader.readLine();

        }
        bufferedReader.close();

        return products;
    }
}
