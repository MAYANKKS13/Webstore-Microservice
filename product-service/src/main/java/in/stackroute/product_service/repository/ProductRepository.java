package in.stackroute.product_service.repository;

import in.stackroute.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    Optional<Product> findBySkuCode(String skuCode);

    @Query("select p from Product p where p.productName like %?1%")
    List<Product> findByProductName(String productName);




}
