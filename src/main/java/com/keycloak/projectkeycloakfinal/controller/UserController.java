package com.keycloak.projectkeycloakfinal.controller;

import com.keycloak.projectkeycloakfinal.entities.User;
import com.keycloak.projectkeycloakfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/newuser")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    @PreAuthorize("hasRole('client_admin')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        userService.getUserById(id);
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
