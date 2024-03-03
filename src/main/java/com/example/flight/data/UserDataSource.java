package com.example.flight.data;

import com.example.flight.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDataSource {
    List<User> retrieveUsers();
    User retrieveUser(UUID id);
    User createUser(User user);
    void deleteUser(UUID id);
    User updateUser(User user);
}
