package service;
import company.Product;
import company.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest
{
    @Test
    public void getAllProductsPositiveTest()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(12,"Jeans",1,1,"Blue",1));
        products.add(new Product(13,"Jeans",1,1,"Blue",1));
        products.add(new Product(14,"Jeans",1,1,"Blue",1));
        products.add(new Product(15,"Jeans",1,1,"Blue",1));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products,productsFromTestClass);
    }
    @Test
    public void getAllProductsNegativeTest()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,1,"Blue",1));
        products.add(new Product(12,"Jeans",1,1,"Blue",1));
        products.add(new Product(13,"Jeans",1,1,"Blue",1));
        products.add(new Product(14,"Jeans",1,1,"Blue",1));
        ProductServiceImpl productService = new ProductServiceImpl();

        //then
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertNotEquals(products,productsFromTestClass);
    }
    @Test
    public void getCountProductsPositiveTest()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",1));
        products.add(new Product(12,"Jeans",31,1,"Yellow",12));
        products.add(new Product(13,"Jeans",12,41,"Red",13));
        products.add(new Product(14,"Jeans",1,11,"Blue",15));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final int result = productService.getCountProducts();

        //expected
        Assert.assertEquals(result,products.size());
    }
    @Test
    public void getCountProductsNegativeTest()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",1));
        products.add(new Product(12,"Jeans",31,1,"Yellow",12));
        products.add(new Product(13,"Jeans",12,41,"Red",13));
        products.add(new Product(14,"Jeans",1,11,"Blue",15));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final int result = productService.getCountProducts();
        products.remove(0);

        //expected
        Assert.assertNotEquals(result,products.size());
    }
    @Test
    public void getProductByProductNameWhenProductExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final Product product = productService.getProductByProductName("Jeans");

        //expected
        Assert.assertEquals(product,products.get(0));
    }
    @Test
    public void getProductByProductNameWhenProductNoExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final Product product = productService.getProductByProductName("Apple");

        //expected
        Assert.assertEquals(null,product);
    }
    @Test
    public void testisProductOnWarehouseWhenIs()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductOnWarehouse("Jeans");

        //expected
        Assert.assertTrue(result);
    }
    @Test
    public void testIsProductOnWarehouseWhenIsNot()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductOnWarehouse("Apple");

        //expected
        Assert.assertFalse(result);
    }
    @Test
    public void testisProductExistByNameWhenProductExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductExist("Jeans");

        //expected
        Assert.assertTrue(result);
    }
    @Test
    public void testisProductExistByNameWhenProductNoExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductExist("Apple");

        //expected
        Assert.assertFalse(result);
    }
    @Test
    public void testisProductExistByIdWhenProductExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductExist(1L);

        //expected
        Assert.assertTrue(result);
    }
    @Test
    public void testisProductExistByIdWhenProductNoExist()
    {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Jeans",1,14,"Blue",11));
        products.add(new Product(12,"Shirt",31,1,"Yellow",122));
        products.add(new Product(13,"Skirt",122,41,"Red",133));
        products.add(new Product(14,"Hat",1,11,"Blue",153));
        ProductServiceImpl productService = new ProductServiceImpl(products);

        //then
        final boolean result = productService.isProductExist(2L);

        //expected
        Assert.assertFalse(result);
    }
}
