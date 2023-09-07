package in.stackroute.order_service.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "order_details")
public class Order {

     @MongoId
     private String orderId;

     @JsonFormat(pattern = "dd-MM-yyyy")
     private LocalDate orderDate;

     private Customer customer;

     private List<Product> products;

     private float totalCost;


}
