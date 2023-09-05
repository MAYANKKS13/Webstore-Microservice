package in.stackroute.controller;


import in.stackroute.exceptions.ProductNotFoundException;

import in.stackroute.model.Inventory;
import in.stackroute.dto.InventoryDto;
import in.stackroute.dto.NewInventoryDto;
import in.stackroute.service.InventoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

        private final InventoryService inventoryService;

        @PostMapping
        public ResponseEntity<InventoryDto> createInventory(@Valid @RequestBody NewInventoryDto dto) throws ProductNotFoundException
          {
            int productId = dto.productId();
            var product = inventoryService.checkIfProductExists(productId); // throws ProductNotFoundException
            var inventory = Inventory.builder()
                    .quantity(dto.quantity())
                    .productId(productId)
                    .productName(product.getProductName())
                    .skuCode(dto.skuCode())
                    .build();
            var savedInventory = inventoryService.save(inventory);
            var savedInventoryDto = new InventoryDto(savedInventory.getId(), savedInventory.getQuantity(),
                    savedInventory.getProductId(), savedInventory.getProductName());
            return ResponseEntity.status(201).body(savedInventoryDto);

          }

}
