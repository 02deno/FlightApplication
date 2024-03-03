package com.example.flight.controller;

import com.example.flight.model.User;
import com.example.flight.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // bu endpointleri sadece admin görsün

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getallUsers")
    public List<User> getUsers() {
        return service.getUsers();
    }

//    @GetMapping("/getUser_{username}")
//    public User getUserByUsername(@PathVariable String username) {
//        return service.getUserByUsername(username);
//    }

}
