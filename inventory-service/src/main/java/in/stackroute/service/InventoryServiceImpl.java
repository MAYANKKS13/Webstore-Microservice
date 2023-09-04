package in.stackroute.service;


import in.stackroute.model.Inventory;
import in.stackroute.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{


    private final InventoryRepository inventoryRepository;


    @Override
    public Inventory findById(int productId) {
        return null;
    }

    @Override
    public void deleteById(int productId) {

        inventoryRepository.deleteById(productId);

    }
}
