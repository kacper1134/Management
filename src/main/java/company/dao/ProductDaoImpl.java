package company.dao;

import company.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    private String fileName;

    public ProductDaoImpl(String fileName)
    {
        this.fileName = fileName;
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
            products.add(fromStringToProduct(line));
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

    public Product fromStringToProduct(String product)
    {
        String [] atributes = {"","","","","",""};

        int index = 0;
        for(int i = 0;i<product.length();i++)
        {
            if(product.charAt(i) == '#')
            {
                index++;
            }
            else
            {
                atributes[index] += (product.charAt(i));
            }
        }
        Product toProduct = new Product(Integer.parseInt(atributes[0]),atributes[1],Integer.parseInt(atributes[2]),
                                        Integer.parseInt(atributes[3]),atributes[4],Integer.parseInt(atributes[5]));

        return toProduct;
    }
}
