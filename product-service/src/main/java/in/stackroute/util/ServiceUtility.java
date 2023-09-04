package in.stackroute.util;

import in.stackroute.model.Product;
import in.stackroute.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Component;

@Component
public class ServiceUtility {

    public Product toEntity(ProductDto dto) {
        return new Product(dto.productName(), dto.description(), dto.unitPrice());
    }

    public ProductDto toDto(Product p) {
        return new ProductDto(p.getProductId(), p.getProductName(), p.getDescription(), p.getUnitPrice());
    }


}
