package in.stackroute.product_service.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @Column(nullable = false)
    private  String productName;

    @Column(unique = true, nullable = false)
    private String skuCode;


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float unitPrice;


    public Product(String productName, String description, float unitPrice) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
    }


}
