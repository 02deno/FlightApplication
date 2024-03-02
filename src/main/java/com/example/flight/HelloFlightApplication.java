package com.example.flight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFlightApplication {
    @GetMapping("/")
    public String helloTau() {
        return "Hello, this is a Flight Application by Deniz!";
    }
}
