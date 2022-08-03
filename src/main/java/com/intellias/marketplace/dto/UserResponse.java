package com.intellias.marketplace.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private long amountOfMoney;
    private List<ProductResponse> products;
}
