package com.intellias.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryRequest {
    private String country;
    private String city;
    private String address;
    @JsonProperty(value = "post_code")
    private int postCode;
}
