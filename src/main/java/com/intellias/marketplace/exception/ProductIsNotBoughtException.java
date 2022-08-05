package com.intellias.marketplace.exception;

public class ProductIsNotBoughtException extends RuntimeException {
    public ProductIsNotBoughtException(String message) {
        super(message);
    }
}
