package in.stackroute.inventory_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewInventoryDto (

        @NotNull @Min(1)
        Integer quantity,
        @NotNull
        Integer productId,
        @NotEmpty
        String skuCode
) {
}
