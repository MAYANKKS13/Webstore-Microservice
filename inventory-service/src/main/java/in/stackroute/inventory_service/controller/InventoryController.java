package in.stackroute.inventory_service.controller;


import in.stackroute.inventory_service.dto.OrderItemsDto;
import in.stackroute.inventory_service.dto.ProductsDto;
import in.stackroute.inventory_service.exceptions.ProductNotFoundException;

import in.stackroute.inventory_service.dto.InventoryDto;
import in.stackroute.inventory_service.model.Inventory;
import in.stackroute.inventory_service.service.InventoryService;
import in.stackroute.inventory_service.dto.NewInventoryDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@Slf4j
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



        @PostMapping("/verify")
        public ResponseEntity<ProductsDto> verifyProducts(@RequestBody OrderItemsDto dto)
        {
            var productids = dto.orderItems().stream().map(oi -> oi.productId()).toList();
            System.out.println(productids);
            System.out.println(dto);
           List<Inventory> allProducts = inventoryService.findAllByProductIdIn(productids);
            System.out.println(allProducts);
//            if(allProducts.isEmpty())
//            {
//                return ResponseEntity.noContent().build();
//            }
//
//            var response = inventoryService.verifyProductIsInStock(allProducts, dto.orderItems());
//            log.debug("Response: {}", response);
//            return ResponseEntity.ok(response);
            return ResponseEntity.noContent().build();
        }



}
