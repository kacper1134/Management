package company;

import java.util.List;

public interface ProductDao
{
    void SaveProduct(Product product);
    void SaveProducts(List<Product> products);
    void removeProductById(Long productId);
    void removeProductByName(String productName);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product getProductByProductName(String productName);
}
