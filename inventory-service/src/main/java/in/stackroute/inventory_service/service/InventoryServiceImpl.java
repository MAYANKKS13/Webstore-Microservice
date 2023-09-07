package in.stackroute.inventory_service.service;


import in.stackroute.inventory_service.dto.OrderItemDto;
import in.stackroute.inventory_service.dto.ProductDto;
import in.stackroute.inventory_service.dto.ProductsDto;
import in.stackroute.inventory_service.exceptions.ProductNotFoundException;
import in.stackroute.inventory_service.model.Inventory;
import in.stackroute.inventory_service.model.Product;
import in.stackroute.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


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
        var response = rest.getForEntity("http://PRODUCT-SERVICE/api/v1/products/" + productId, Product.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }


}


    @Override
    public List<Inventory> findAllByProductIdIn(List<Integer> productIds) {
        System.out.println(productIds);
        return inventoryRepository.findAllByProductId(productIds);
    }

    @Override
    public ProductsDto verifyProductIsInStock(List<Inventory> inventory, List<OrderItemDto> orderItems) {


        List<ProductDto> products = new ArrayList<>();
        orderItems
                .stream()
                .forEach(oi ->
                        inventory
                                .stream()
                                .filter(i -> i.getProductId() == oi.productId())
                                .findFirst()
                                .ifPresent(i -> products.add(new ProductDto(i.getProductId(), oi.quantity(),i.getQuantity() >= oi.quantity()))));




        return new ProductsDto(products);
    }
}
