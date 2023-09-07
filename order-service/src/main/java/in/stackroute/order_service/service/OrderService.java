package in.stackroute.order_service.service;

import in.stackroute.order_service.dto.OrderItems;
import in.stackroute.order_service.dto.OrderRequestDto;
import in.stackroute.order_service.dto.ProductsPriceDto;
import in.stackroute.order_service.dto.ProductsStockDto;
import in.stackroute.order_service.model.Order;

public interface OrderService {

      Order createOrder(OrderRequestDto order);
      ProductsStockDto verifyOrder(OrderItems orderItems);
      ProductsPriceDto fetchPriceDetails(OrderItems orderItems);


}
