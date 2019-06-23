package company;

import company.enums.Color;
import company.enums.Material;
import company.enums.ProductSeparators;

public class Cloth extends Product
{
    private String size;
    private Material material;

    public Cloth(int id, String productName, float price, float weight, Color color, int productCount, String size, Material material)
    {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize()
    {
        return size;
    }

    public Material getMaterial()
    {
        return material;
    }

    @Override
    public String toString()
    {
        return ProductSeparators.CLOTH_ID.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material.toString();
    }
}
