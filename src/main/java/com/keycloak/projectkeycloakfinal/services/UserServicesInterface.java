package com.keycloak.projectkeycloakfinal.services;

import com.keycloak.projectkeycloakfinal.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServicesInterface {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(User user, int id);

    void deleteUser(int id);
}