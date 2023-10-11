package com.desafios.user.controller;

import com.desafios.user.model.UserDTO;
import com.desafios.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping(value = "/users/{userId}", produces = "application/json")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        var user = service.getUser(userId);
        return ResponseEntity.ok(user);
    }
}

