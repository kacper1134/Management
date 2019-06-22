package company;

public class Boots extends Product
{
    private int size;
    private boolean isNaturalSkin;
    public static final String productType = "B";

    public Boots(int id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin)
    {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isNaturalSkin()
    {
        return isNaturalSkin;
    }

    @Override
    public String toString()
    {
        return Boots.productType+"#"+super.getId()+"#"+super.getProductName()+"#"+super.getPrice()+"#"+super.getWeight()
                +"#"+super.getColor()+"#"+super.getProductCount()+"#"+size+"#"+isNaturalSkin;
    }
}
