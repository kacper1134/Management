package company;

public class Product
{
    private int id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;
    public static final String PRODUCT_SEPARATOR = "#";
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

    @Override
    public String toString()
    {
        return id + "#" + productName+"#"+price+"#"+weight+"#"+color+"#"+productCount;
    }
}
