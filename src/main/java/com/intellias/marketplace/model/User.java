package com.intellias.marketplace.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class User {
private UUID id;
private String firstName;
private String lastName;
private long amountOfMoney;
private List<Product> products;
}
