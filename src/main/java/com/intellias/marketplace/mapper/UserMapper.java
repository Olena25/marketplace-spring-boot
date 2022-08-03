package com.intellias.marketplace.mapper;

import com.intellias.marketplace.dto.UserResponse;
import com.intellias.marketplace.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper {

    private ProductMapper productMapper;

    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setAmountOfMoney(user.getAmountOfMoney());
        userResponse.setProducts(productMapper.mapToProductResponses(user.getProducts()));

        return userResponse;
    }

    public List<UserResponse> mapToUserResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(mapToUserResponse(user));
        }

        return userResponses;
    }
}
