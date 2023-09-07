package in.stackroute.order_service.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private int productId;
    private int quantity;
    private float price;

}
