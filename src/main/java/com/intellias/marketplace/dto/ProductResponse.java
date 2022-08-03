package com.intellias.marketplace.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private long price;
}
