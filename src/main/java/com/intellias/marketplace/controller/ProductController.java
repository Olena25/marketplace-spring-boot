package com.intellias.marketplace.controller;

import com.intellias.marketplace.dto.ProductRequest;
import com.intellias.marketplace.dto.ProductResponse;
import com.intellias.marketplace.service.ProductService;
import com.intellias.marketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private UserService userService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.add(productRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> findAllProduct() {
        return productService.findAll();
    }


    @DeleteMapping("/users/products/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        userService.deleteProduct(productId);
        productService.deleteProduct(productId);
    }
}
