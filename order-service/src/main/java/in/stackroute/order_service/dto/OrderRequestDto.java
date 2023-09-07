package in.stackroute.order_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record OrderRequestDto(

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate orderDate,
        String name,
        String email,
        String phone,
        String street,
        String city,
        String state,
        String zip,
        String country,
        List<OrderItem> orderItems


        ) {
}
