package com.keycloak.projectkeycloakfinal.repositories;

import com.keycloak.projectkeycloakfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
