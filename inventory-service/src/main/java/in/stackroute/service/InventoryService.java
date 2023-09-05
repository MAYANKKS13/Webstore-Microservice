package in.stackroute.service;

import in.stackroute.exceptions.ProductNotFoundException;
import in.stackroute.model.Inventory;
import in.stackroute.model.Product;

public interface InventoryService {

    Inventory save(Inventory inventory);
    Inventory update(Inventory inventory);
    Product checkIfProductExists(int productId) throws ProductNotFoundException;




}
