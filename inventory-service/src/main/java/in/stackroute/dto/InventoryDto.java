package in.stackroute.dto;

import jakarta.validation.constraints.Min;

public record InventoryDto(

        int id,

        int quantity,

        int productId,

        String productName


) {
}
