package com.keycloak.projectkeycloakfinal.repositories;

import com.keycloak.projectkeycloakfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
