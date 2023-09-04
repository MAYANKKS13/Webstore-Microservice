package in.stackroute.service;


import in.stackroute.exceptions.ProductNotFoundException;
import in.stackroute.model.Product;
import in.stackroute.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;



    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(
                        () -> new ProductNotFoundException("Cannot find product with id " + productId
                                + " in the database"));

    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int productId) {
        productRepository.deleteById(productId);
    }
}
