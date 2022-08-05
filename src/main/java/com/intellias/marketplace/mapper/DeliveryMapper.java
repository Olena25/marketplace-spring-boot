package com.intellias.marketplace.mapper;

import com.intellias.marketplace.dto.DeliveryRequest;
import com.intellias.marketplace.dto.DeliveryResponse;
import com.intellias.marketplace.dto.ProductResponse;
import com.intellias.marketplace.model.Delivery;
import com.intellias.marketplace.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DeliveryMapper {
    private UserMapper userMapper;
    private ProductMapper productMapper;
    public DeliveryResponse mapToDeliveryResponse(Delivery delivery) {
        DeliveryResponse deliveryResponse = new DeliveryResponse();
        deliveryResponse.setId(delivery.getId());
        deliveryResponse.setUser(userMapper.mapToUserResponse(delivery.getUser()));
        deliveryResponse.setProduct(productMapper.mapToProductResponse(delivery.getProduct()));
        deliveryResponse.setDeliveryAddress(delivery.getDeliveryAddress());
        deliveryResponse.setTotalAmount(delivery.getTotalAmount());
        return deliveryResponse;
    }
    public List<DeliveryResponse> mapToDeliveryResponse(List<Delivery> deliveries) {
        List<DeliveryResponse> deliveryResponses = new ArrayList<>();
        for(Delivery delivery: deliveries) {
            deliveryResponses.add(mapToDeliveryResponse(delivery));
        }

        return deliveryResponses;
    }
}
