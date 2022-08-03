package com.intellias.marketplace.service;

import com.intellias.marketplace.db.ProductDatabase;
import com.intellias.marketplace.dto.ProductRequest;
import com.intellias.marketplace.dto.ProductResponse;
import com.intellias.marketplace.exception.ProductNotFoundException;
import com.intellias.marketplace.mapper.ProductMapper;
import com.intellias.marketplace.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private ProductDatabase productDatabase;
    private ProductMapper productMapper;

    public List<ProductResponse> findAll() {
        log.info("Searching for all products");
        List<Product> products = productDatabase.findAll();

        return productMapper.mapToProductResponses(products);
    }

    public Product findById(String productId) {
        Product product = productDatabase.findProductById(productId);

        if (product == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        return product;
    }

    public void add(ProductRequest productRequest) {
        if (productRequest.getPrice() < 0) {
            throw new IllegalArgumentException("Price can not be negative");
        }

        log.info("Add new product with name {} ", productRequest.getName());
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setId(UUID.randomUUID());

        productDatabase.save(product);
    }

    public void deleteProduct(String productId) {
        log.info("Trying to delete product with id {}", productId);
        Product product = findById(productId);
        productDatabase.delete(product);
    }
}
