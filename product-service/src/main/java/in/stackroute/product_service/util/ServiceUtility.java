package in.stackroute.product_service.util;

import in.stackroute.product_service.model.Product;
import in.stackroute.product_service.dto.ProductDto;

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
