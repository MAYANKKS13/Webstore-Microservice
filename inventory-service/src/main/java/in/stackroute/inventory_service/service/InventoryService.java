package in.stackroute.inventory_service.service;


import in.stackroute.inventory_service.dto.ProductsDto;
import in.stackroute.inventory_service.dto.OrderItemDto;
import in.stackroute.inventory_service.exceptions.ProductNotFoundException;
import in.stackroute.inventory_service.model.Inventory;
import in.stackroute.inventory_service.model.Product;

import java.util.List;

public interface InventoryService {

    Inventory save(Inventory inventory);
    Inventory update(Inventory inventory);
    Product checkIfProductExists(int productId) throws ProductNotFoundException;

    List<Inventory> findAllByProductIdIn(List<Integer> productIds);

    ProductsDto verifyProductIsInStock(List<Inventory> inventory, List<OrderItemDto> orderItems);



}
