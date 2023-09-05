package in.stackroute.controller;


import in.stackroute.dto.ProductDto;
import in.stackroute.exceptions.ProductAlreadyExists;
import in.stackroute.exceptions.ProductNotFoundException;
import in.stackroute.model.Product;
import in.stackroute.util.ServiceUtility;
import jakarta.validation.Valid;
import in.stackroute.service.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.future.AbstractFutureEpochBasedValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ServiceUtility util;
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);



    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto dto)
    {

        var product = util.toEntity(dto);
        productService.findBySkuCode(product.getSkuCode()).ifPresent(p -> {
            throw new ProductAlreadyExists("Product with skuCode " + product.getSkuCode() + " already exists");
        });

        var savedProduct = productService.save(product);
        var savedProductDto = util.toDto(savedProduct);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedProductDto);

    }



    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int id)
    {
        var product = productService.findById(id);
        var productDto = util.toDto(product);
        return ResponseEntity.ok(productDto);
    }



    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductByName(@RequestParam("name") String name) {
        var productList = productService.findByProductName(name);
        if (productList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var productDtoList = productList.stream().map(product -> util.toDto(product)).toList();
        return ResponseEntity.ok(productDtoList);
    }

    // GET http://localhost:8080/api/v1/products?skuCode=ABC123
    @GetMapping(params = "skuCode")
    public ResponseEntity<ProductDto> getProductBySkuCode(@RequestParam("skuCode") String skuCode) {
        var product = productService.findBySkuCode(skuCode)
                .orElseThrow(() -> new ProductNotFoundException("Product with skuCode " + skuCode + " not found"));
        var productDto = util.toDto(product);
        return ResponseEntity.ok(productDto);
    }




    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") int id, @RequestBody ProductDto dto)
    {
        var product = util.toEntity(dto);
        product.setProductId(id);
        var updatedProduct = productService.update(product);
        var updatedProductDto = util.toDto(updatedProduct);
        return ResponseEntity.ok(updatedProductDto);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id)
    {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
