package com.intellias.marketplace.dto;

import com.intellias.marketplace.model.Product;
import com.intellias.marketplace.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private UUID id;
    private UserResponse user;
    private ProductResponse product;
    private int totalAmount;
    private String deliveryAddress;
}
