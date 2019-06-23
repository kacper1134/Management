package company.parser;

import company.Boots;
import company.Cloth;
import company.Product;

public class ProductParser
{
    public Product stringToProduct(String product)
    {
        switch(product.charAt(0))
        {
            case 'P':
            {
                return convertToProduct(product);
            }
            case 'C':
            {
                return convertToCloth(product);
            }
            case 'B':
            {
                return convertToBoots(product);
            }
            default:
            {
                return convertToProduct(product);
            }
        }
    }
    private Product convertToProduct(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id,productName,price,weight,color,productCount);
    }
    private Cloth convertToCloth(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        String material = productInformation[8];
        return new Cloth(id,productName,price,weight,color,productCount,size,material);
    }
    private Boots convertToBoots(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[8]);

        return new Boots(id,productName,price,weight,color,productCount,size,isNaturalSkin);
    }
}
