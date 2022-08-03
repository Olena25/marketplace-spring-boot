package com.intellias.marketplace.service;

import com.intellias.marketplace.db.UserDatabase;
import com.intellias.marketplace.dto.UserResponse;
import com.intellias.marketplace.exception.NotEnoughMoneyException;
import com.intellias.marketplace.model.Product;
import com.intellias.marketplace.dto.UserRequest;
import com.intellias.marketplace.exception.UserNotFoundException;
import com.intellias.marketplace.exception.UserValidationException;
import com.intellias.marketplace.mapper.UserMapper;
import com.intellias.marketplace.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserDatabase userDatabase;
    private ProductService productService;
    private UserMapper userMapper;

    public List<UserResponse> findAll() {
        log.info("Searching for all users");
        List<User> users = userDatabase.findAll();
        return userMapper.mapToUserResponses(users);
    }

    public void add(UserRequest userDto) {
        log.info("Adding user");
        if (userDto.getFirstName().isEmpty() || userDto.getLastName().isEmpty()) {
            log.error("First name or last name empty");

            throw new UserValidationException("First name or last name is empty");
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAmountOfMoney(userDto.getAmountOfMoney());
        user.setProducts(new ArrayList<>());
        user.setId(UUID.randomUUID());

        userDatabase.save(user);
    }

    public User findById(String userId) {
        User user = userDatabase.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        return user;
    }

    public void buyProductForUser(String userId, String productId) {


        log.info("Buy product for userId {} and productId {}", userId, productId);

        User user = findById(userId);
        Product product = productService.findById(productId);

        if (user.getAmountOfMoney() < product.getPrice()) {
            throw new NotEnoughMoneyException("User with id " + userId + " does not have enough money to buy product");
        }

        user.getProducts().add(product);
        long newAmountOfMoney = user.getAmountOfMoney() - product.getPrice();
        user.setAmountOfMoney(newAmountOfMoney);
    }

    public List<UserResponse> findUsersByProduct(Product product) {
        log.info("Trying to find users by product id {}", product.getId());

        List<User> users = userDatabase.findAll();

        List<User> foundUsers = new ArrayList<>();
        for (User user : users) {
            List<Product> products = user.getProducts();
            if (products.contains(product)) {
                foundUsers.add(user);
            }
        }

        return userMapper.mapToUserResponses(foundUsers);
    }

    public void deleteUser(String userId) {
        log.info("Trying to delete user with id {}", userId);
        User user = findById(userId);
        userDatabase.delete(user);
    }

    public void deleteProduct(String productId) {
        Product product = productService.findById(productId);
        List<User> users = userDatabase.findAll();
        for (User user : users) {
            List<Product> userProducts = user.getProducts();
            userProducts.remove(product);
        }
    }
}
