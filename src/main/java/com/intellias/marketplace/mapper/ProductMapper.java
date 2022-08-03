package com.intellias.marketplace.mapper;

import com.intellias.marketplace.model.Product;
import com.intellias.marketplace.dto.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public ProductResponse mapToProductResponse(Product product) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());

            return productResponse;
    }

    public List<ProductResponse> mapToProductResponses(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product: products) {
            productResponses.add(mapToProductResponse(product));
        }

        return productResponses;
    }
}
