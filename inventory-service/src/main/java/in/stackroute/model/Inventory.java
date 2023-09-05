package in.stackroute.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    private int productId;

    private String productName;

    private String skuCode;
}
