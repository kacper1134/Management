package company;

import company.enums.ProductSeparators;

public class Product
{
    private int id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;

    public Product(int id, String productName, float price, float weight, String color, int productCount)
    {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public int getId()
    {
        return id;
    }

    public String getProductName()
    {
        return productName;
    }

    public float getPrice()
    {
        return price;
    }

    public float getWeight()
    {
        return weight;
    }

    public String getColor()
    {
        return color;
    }

    public int getProductCount()
    {
        return productCount;
    }

    public void setProductCount(int productCount)
    {
        this.productCount = productCount;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    protected String getBasicProductString()
    {
        return  ProductSeparators.PRODUCT_SEPARATOR.toString() + id +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + productName+ProductSeparators.PRODUCT_SEPARATOR.toString()+
                price+ProductSeparators.PRODUCT_SEPARATOR.toString()+weight+ProductSeparators.PRODUCT_SEPARATOR.toString()+color+
                ProductSeparators.PRODUCT_SEPARATOR.toString()+productCount;
    }

    @Override
    public String toString()
    {
        return ProductSeparators.PRODUCT_ID.toString() + getBasicProductString();
    }


}
