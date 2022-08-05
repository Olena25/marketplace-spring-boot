package com.intellias.marketplace.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity( name = "delivery")
public class Delivery {
    @Id
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    @Column(name = "total_amount")
    private int totalAmount;
    @Column(name = "delivery_address")
    private String deliveryAddress;
}
