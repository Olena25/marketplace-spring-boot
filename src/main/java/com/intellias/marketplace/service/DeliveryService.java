package com.intellias.marketplace.service;

import com.intellias.marketplace.db.DeliveryRepository;
import com.intellias.marketplace.dto.DeliveryRequest;
import com.intellias.marketplace.dto.DeliveryResponse;
import com.intellias.marketplace.exception.ProductIsNotBoughtException;
import com.intellias.marketplace.exception.ProductNotFoundException;
import com.intellias.marketplace.mapper.DeliveryMapper;
import com.intellias.marketplace.model.Delivery;
import com.intellias.marketplace.model.Product;
import com.intellias.marketplace.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeliveryService {

    private ProductService productService;
    private UserService userService;
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    public DeliveryResponse createDelivery(String userId, String productId, DeliveryRequest deliveryRequest) {
        User user = userService.findById(userId);
        Product product = productService.findById(productId);
        if (!user.getProducts().contains(product)) {
            throw new ProductIsNotBoughtException("User does not have this product");
        }
        Delivery delivery = new Delivery();
        delivery.setDeliveryAddress(createDeliveryAddress(deliveryRequest));
        delivery.setUser(user);
        delivery.setProduct(product);
        delivery.setTotalAmount((int)product.getPrice());
        delivery.setId(UUID.randomUUID());
        deliveryRepository.save(delivery);
        return deliveryMapper.mapToDeliveryResponse(delivery);
    }

    private String createDeliveryAddress(DeliveryRequest deliveryRequest) {
        return deliveryRequest.getCountry() + " , " + deliveryRequest.getCity() + " , " +
                deliveryRequest.getAddress() + " , " + deliveryRequest.getPostCode();

    }
}
