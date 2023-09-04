package in.stackroute.dto;

import jakarta.validation.constraints.NotEmpty;

public record InventoryDto(

        int id,
        @NotEmpty
        int quantity,
        @NotEmpty
        int productId,
        @NotEmpty
        String ProductName


) {
}
