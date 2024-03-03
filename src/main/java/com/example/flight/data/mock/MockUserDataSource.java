package com.example.flight.data.mock;

import com.example.flight.data.UserDataSource;
import com.example.flight.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockUserDataSource implements UserDataSource {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    List<GrantedAuthority> userAuthorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_USER")));
    List<GrantedAuthority> adminAuthorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));


    private final List<User> users = new ArrayList<>(Arrays.asList(
            new User(UUID.randomUUID(), "alper", passwordEncoder.encode("armut"), userAuthorities),
            new User(UUID.randomUUID(), "deniz", passwordEncoder.encode("deniz"), adminAuthorities)
    ));


    @Override
    public List<User> retrieveUsers() {
        return users;
    }

    @Override
    public User retrieveUser(UUID id) {
        Optional<User> userOptional = users.stream()
                .filter(currentUser-> currentUser.getId().equals(id))
                .findFirst();
        return userOptional.orElseThrow(() -> new NoSuchElementException("Could not find a User with id " + id));
    }

    @Override
    public User createUser(User newUser) {
        for (User user : users) {
            if (user.getId().equals(newUser.getId())) {
                throw new IllegalArgumentException("User with id " + newUser.getId() + " already exists");
            }
        }
        users.add(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(UUID id) {
        User currentUser = null;
        for (User user : users) {
            if (user.getId().equals(id)) {
                currentUser = user;
                break;
            }
        }
        if (currentUser == null) {
            throw new NoSuchElementException("Could not find a User with id " + id);
        }
        users.remove(currentUser);
    }

    @Override
    public User updateUser(User newUser) {
        User currentUser = null;
        for (User user : users) {
            if (user.getId().equals(newUser.getId())) {
                currentUser = user;
                break;
            }
        }
        if (currentUser == null) {
            throw new NoSuchElementException("Could not find a User with id " + newUser.getId());
        }
        users.remove(currentUser);
        users.add(newUser);
        return newUser;
    }
}
