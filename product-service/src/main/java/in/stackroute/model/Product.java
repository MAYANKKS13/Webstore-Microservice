package in.stackroute.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @Column(nullable = false)
    private  String productName;

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
