package company;

import company.enums.ProductSeparators;

public class Cloth extends Product
{
    private String size;
    private String material;

    public Cloth(int id, String productName, float price, float weight, String color, int productCount, String size, String material)
    {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize()
    {
        return size;
    }

    public String getMaterial()
    {
        return material;
    }

    @Override
    public String toString()
    {
        return ProductSeparators.CLOTH_ID.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
    }
}
