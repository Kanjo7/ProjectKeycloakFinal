package com.keycloak.projectkeycloakfinal.services;

import com.keycloak.projectkeycloakfinal.entities.User;

import java.util.List;

public interface UserServicesInterface {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(User user, int id);

    void deleteUser(int id);
}