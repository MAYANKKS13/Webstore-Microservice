package in.stackroute.order_service.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private String name;
    private String email;
    private String phone;
    private Address address;


}
