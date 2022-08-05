package com.intellias.marketplace.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "product")
public class Product {
    @Id
    private UUID id;
    private String name;
    private long price;
}
