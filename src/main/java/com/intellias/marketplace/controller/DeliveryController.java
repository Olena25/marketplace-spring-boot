package com.intellias.marketplace.controller;

import com.intellias.marketplace.dto.DeliveryRequest;
import com.intellias.marketplace.dto.DeliveryResponse;
import com.intellias.marketplace.service.DeliveryService;
import com.intellias.marketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;
    private UserService userService;

    @PostMapping("/users/{user_id}/products/{product_id}/delivery")
    public DeliveryResponse createDelivery(@PathVariable("user_id") String userId,
                                           @PathVariable("product_id") String productId,
                                           @RequestBody DeliveryRequest deliveryRequest) {
        return deliveryService.createDelivery(userId, productId, deliveryRequest);
    }

    @GetMapping("/users/{user_id}/delivery")
    public List<DeliveryResponse> getUserDeliveries(@PathVariable("user_id") String userId){
        return userService.findDeliveries(userId);
    }

}
