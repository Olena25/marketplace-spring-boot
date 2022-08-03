package com.intellias.marketplace.db;

import com.intellias.marketplace.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductDatabase {

    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        log.info("Saving product {} to database", product.getId());
        products.add(product);
    }

    public Product findProductById(String productId) {
        for (Product product : products) {
            if (productId.equals(product.getId().toString())) {
                return product;
            }
        }
        return null;
    }

    public void delete(Product product) {
        products.remove(product);


    }

}
