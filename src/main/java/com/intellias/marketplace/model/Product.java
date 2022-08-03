package com.intellias.marketplace.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "product")
public class Product {
    @Id
    private UUID id;
    private String name;
    private long price;
}
