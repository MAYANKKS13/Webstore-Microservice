package in.stackroute.order_service.controller;

import in.stackroute.order_service.dto.OrderRequestDto;
import in.stackroute.order_service.model.Order;
import in.stackroute.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

       private final OrderService orderService;

       @PostMapping
       public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDto dto)
       {
           return ResponseEntity.status(201).body(orderService.createOrder(dto));
       }

}
