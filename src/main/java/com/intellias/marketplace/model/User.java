package com.intellias.marketplace.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "user")
public class User {
    @Id
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "money")
    private long amountOfMoney;
    @ManyToMany
    private List<Product> products;
    @OneToMany(mappedBy = "user")
    private List<Delivery> deliveries;
}
