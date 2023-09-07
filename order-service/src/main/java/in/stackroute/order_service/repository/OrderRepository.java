package in.stackroute.order_service.repository;

import in.stackroute.order_service.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {



}
