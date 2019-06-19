package company.parse;

import company.Boots;
import company.Cloth;
import company.Product;

public class ProductParser
{
    public Product stringToProduct(String product,String productType)
    {
        if(productType.equals("PRODUCT"))
        {
            return convertToProduct(product);
        }
        else if(productType.equals("CLOTH"))
        {
            return convertToCloth(product);
        }
        else
        {
            return convertToBoots(product);
        }
    }
    private Product convertToProduct(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);

        return new Product(id,productName,price,weight,color,productCount);
    }
    private Cloth convertToCloth(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);
        String size = productInformation[6];
        String material = productInformation[7];
        return new Cloth(id,productName,price,weight,color,productCount,size,material);
    }
    private Boots convertToBoots(String product)
    {
        String [] productInformation = product.split(Product.PRODUCT_SEPARATOR);
        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);
        int size = Integer.parseInt(productInformation[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[7]);

        return new Boots(id,productName,price,weight,color,productCount,size,isNaturalSkin);
    }
}
