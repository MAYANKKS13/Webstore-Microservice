package in.stackroute.order_service.dto;

public record ProductDto(int productId, int quantity, boolean inStock, double price) {
}
