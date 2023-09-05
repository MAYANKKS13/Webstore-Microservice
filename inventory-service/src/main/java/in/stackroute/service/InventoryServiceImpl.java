package in.stackroute.service;


import in.stackroute.exceptions.ProductNotFoundException;
import in.stackroute.model.Inventory;
import in.stackroute.model.Product;
import in.stackroute.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{


    private final InventoryRepository inventoryRepository;
    private final RestTemplate rest;


    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
           return inventoryRepository.save(inventory);
    }

    @Override
    public Product checkIfProductExists(int productId) throws ProductNotFoundException {
        var response = rest.getForEntity("http://localhost:8081/api/v1/products/" + productId, Product.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }


}
}
