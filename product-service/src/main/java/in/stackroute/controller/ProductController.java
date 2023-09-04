package in.stackroute.controller;


import in.stackroute.dto.ProductDto;
import in.stackroute.exceptions.ProductNotFoundException;
import in.stackroute.model.Product;
import in.stackroute.util.ServiceUtility;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ServiceUtility util;
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto)
    {
        logger.debug("Creating product: {}", dto);
        var product = util.toEntity(dto);
        logger.debug("Product to be saved: {}", product);
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




    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(HttpHeaders headers,
                                                                 @NotNull ProductNotFoundException ex)
    {

        Map<String,Object> response = new HashMap<>();
        response.put("timestamp",System.currentTimeMillis());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("message",ex.getMessage());
        return new ResponseEntity<>(response,headers,HttpStatus.NOT_FOUND);


    }





}
