package in.stackroute.product_service.service;

import in.stackroute.product_service.model.Product;

import java.util.*;

public interface ProductService {

    Product save(Product product);

    Product findById(int productId);

    Product update(Product product);

    void deleteById(int productId);

    Optional<Product> findBySkuCode(String skuCode);

    List<Product> findByProductName(String productName);




}
