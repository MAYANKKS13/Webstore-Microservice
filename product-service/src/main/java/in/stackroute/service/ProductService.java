package in.stackroute.service;

import in.stackroute.model.Product;

public interface ProductService {

    Product save(Product product);

    Product findById(int productId);

    Product update(Product product);

    void deleteById(int productId);


}
