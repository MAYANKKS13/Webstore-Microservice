package in.stackroute.order_service.service;


import in.stackroute.order_service.dto.OrderItems;
import in.stackroute.order_service.dto.OrderRequestDto;
import in.stackroute.order_service.dto.ProductsPriceDto;
import in.stackroute.order_service.dto.ProductsStockDto;
import in.stackroute.order_service.model.Order;
import in.stackroute.order_service.util.OrderConverter;
import in.stackroute.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {


      private final OrderRepository orderRepository;
      private final OrderConverter converter;
      private final RestTemplate rest;


    @Override
    public Order createOrder(OrderRequestDto order) {

          log.info("Creating {} order", order);
          var response = verifyOrder(new OrderItems(order.orderItems()));
          if(response.products().isEmpty())
          {
              throw new RuntimeException("No products found");
          }

          boolean anyMatch = response.products().stream().anyMatch(product -> !product.inStock());

          if(anyMatch)
          {
              throw new RuntimeException("Some products are out of stock");
          }

          return orderRepository.save(converter.convertToOrder(order));
    }

    @Override
    public ProductsStockDto verifyOrder(OrderItems orderItems) {

          var response = rest.postForEntity("http://INVENTORY-SERVICE/api/v1/inventory/verify",
                  orderItems,ProductsStockDto.class);
        log.info("Inventory service responded with {}", response.getStatusCode().value());
          if(response.getStatusCode().is2xxSuccessful())
          {
              log.info("Inventory service responded with {}", response.getBody());
              return response.getBody();
          }
          else {
              throw new RuntimeException("Inventory service is down");
          }

    }

    @Override
    public ProductsPriceDto fetchPriceDetails(OrderItems orderItems) {
        return null;
    }
}
