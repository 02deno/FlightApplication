package com.example.flight.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {
    private UUID id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

}
