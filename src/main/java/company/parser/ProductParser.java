package company.parser;

import company.Boots;
import company.Cloth;
import company.Product;
import company.enums.Color;
import company.enums.Material;
import company.enums.ProductSeparators;
import company.enums.SkinType;

public class ProductParser
{
    public Product stringToProduct(String product)
    {
        String seperator = product.substring(0,1);

        switch(stringToProductSeperator(seperator))
        {
            case PRODUCT_ID:
            {
                return convertToProduct(product);
            }
            case BOOTS_ID:
            {
                return convertToBoots(product);
            }
            case CLOTH_ID:
            {
                return convertToCloth(product);
            }
            default:
            {
                return null;
            }
        }
    }
    private Product convertToProduct(String product)
    {
        String [] productInformation = product.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        Color color = ColorParser.strToColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id,productName,price,weight,color,productCount);
    }
    private Cloth convertToCloth(String product)
    {
        String [] productInformation = product.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        Color color = ColorParser.strToColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        Material material = MaterialParser.strToMaterial(productInformation[8]);
        return new Cloth(id,productName,price,weight,color,productCount,size,material);
    }
    private Boots convertToBoots(String product)
    {
        String [] productInformation = product.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        Color color = ColorParser.strToColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        SkinType skinType = SkinParser.strToSkinType(productInformation[8]);

        return new Boots(id,productName,price,weight,color,productCount,size,skinType);
    }
    private ProductSeparators stringToProductSeperator(String str)
    {
        for(ProductSeparators productSeparators : ProductSeparators.values())
        {
            if(productSeparators.toString().equals(str))
            {
                return productSeparators;
            }
        }
        return null;
    }
}
