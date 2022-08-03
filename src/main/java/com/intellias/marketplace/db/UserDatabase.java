package com.intellias.marketplace.db;

import com.intellias.marketplace.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDatabase {

    private List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public User findById(String userId) {
        for (User user : users) {
            if (userId.equals(user.getId().toString())) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        users.remove(user);
    }

}
