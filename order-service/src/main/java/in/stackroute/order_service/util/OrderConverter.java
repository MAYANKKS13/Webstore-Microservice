package in.stackroute.order_service.util;


import in.stackroute.order_service.dto.OrderRequestDto;
import in.stackroute.order_service.model.Address;
import in.stackroute.order_service.model.Customer;
import in.stackroute.order_service.model.Order;
import in.stackroute.order_service.model.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

      public Order convertToOrder(OrderRequestDto dto)
      {
          var address = Address
                  .builder()
                  .street(dto.street())
                  .city(dto.city())
                  .state(dto.state())
                  .zip(dto.zip())
                  .country(dto.country())
                  .build();

          var customer = Customer
                  .builder()
                  .name(dto.name())
                  .email(dto.email())
                  .phone(dto.phone())
                  .address(address)
                  .build();

          var products = dto.orderItems()
                  .stream()
                  .map(item -> Product
                          .builder()
                          .productId(item.productId())
                          .quantity(item.quantity())
                          .build()
                  ).toList();

          return Order
                  .builder()
                  .orderDate(dto.orderDate())
                  .customer(customer)
                  .products(products)
                  .totalCost(0)
                  .build();


      }






}
