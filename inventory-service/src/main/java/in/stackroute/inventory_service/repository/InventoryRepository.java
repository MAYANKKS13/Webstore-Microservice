package in.stackroute.inventory_service.repository;

import in.stackroute.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {


    List<Inventory> findAllByProductId(List<Integer> productIds);

}
