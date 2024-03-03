package com.example.flight.service;

import com.example.flight.data.UserDataSource;
import com.example.flight.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserDataSource dataSource;

    public UserService(UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getUsers() {
        return dataSource.retrieveUsers();
    }

    public User getUser(UUID id) {
        return dataSource.retrieveUser(id);
    }

    public User addUser(User User) {
        return dataSource.createUser(User);
    }

    public void deleteUser(UUID id) {
        dataSource.deleteUser(id);
    }

    public User updateUser(User User) {
        return dataSource.updateUser(User);
    }
}
