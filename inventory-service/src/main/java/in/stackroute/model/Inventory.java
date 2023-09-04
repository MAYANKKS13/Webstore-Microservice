package in.stackroute.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue
    private int id;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int productId;

    @Column(nullable = false)
    private String ProductName;

    public Inventory(int quantity, int productId, String productName) {
        this.quantity = quantity;
        this.productId = productId;
        ProductName = productName;
    }
}
