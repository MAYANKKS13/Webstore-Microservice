package in.stackroute.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;

public record ProductDto(
        int productId,
        @NotEmpty(message = "Product must have a name")
        String productName,
        @NotEmpty(message = "Product must have a description")
        String description,
        @DecimalMin(message = "Unit price must be atleast 1.0", value = "1.0")
        float unitPrice
) {
}






