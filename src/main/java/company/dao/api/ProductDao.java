package company.dao.api;

import company.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao
{
    void SaveProduct(Product product) throws IOException;
    void SaveProducts(List<Product> products) throws FileNotFoundException;
    void removeProductById(Long productId) throws IOException;
    void removeProductByName(String productName) throws IOException;
    List<Product> getAllProducts() throws IOException;
}
