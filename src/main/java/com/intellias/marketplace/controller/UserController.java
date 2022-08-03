package com.intellias.marketplace.controller;

import com.intellias.marketplace.dto.UserResponse;
import com.intellias.marketplace.model.Product;
import com.intellias.marketplace.service.UserService;
import com.intellias.marketplace.dto.UserRequest;
import com.intellias.marketplace.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private ProductService productService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserRequest userRequest) {
        userService.add(userRequest);
    }

    @GetMapping("/users")
    public List<UserResponse> findAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users/{userId}/products/{productId}")
    public void buyProductForUser(@PathVariable String userId, @PathVariable String productId) {
        userService.buyProductForUser(userId, productId);
    }

    @GetMapping("/users/products/{productId}")
    public List<UserResponse> findUsersByProduct(@PathVariable String productId) {
        Product product = productService.findById(productId);
        return userService.findUsersByProduct(product);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
