package in.stackroute.order_service.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {


    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;



}
