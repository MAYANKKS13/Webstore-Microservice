package in.stackroute.service;

import in.stackroute.model.Inventory;

public interface InventoryService {

    Inventory findById(int productId);
    void deleteById(int productId);




}
