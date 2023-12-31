package in.stackroute.inventory_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int productId;
    private String productName;
    private String description;
    private float unitPrice;


}
