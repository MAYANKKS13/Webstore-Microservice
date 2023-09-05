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
        return Product
                .builder()
                .productName(dto.productName())
                .skuCode(dto.skuCode())
                .description(dto.description())
                .unitPrice(dto.unitPrice())
                .build();

    }

    public ProductDto toDto(Product p) {
        return new ProductDto(p.getProductId(), p.getProductName(), p.getSkuCode(), p.getDescription(), p.getUnitPrice());
    }


}
