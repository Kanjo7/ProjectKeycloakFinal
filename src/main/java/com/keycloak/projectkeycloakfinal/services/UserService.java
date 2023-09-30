package com.keycloak.projectkeycloakfinal.services;

import com.keycloak.projectkeycloakfinal.entities.User;
import com.keycloak.projectkeycloakfinal.exceptions.ResourceNotFoundException;
import com.keycloak.projectkeycloakfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServicesInterface {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User updateUser(User user, int id) {
        User u = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        u.setMemberType(user.getMemberType());

        userRepository.save(u);

        return u;
    }
}
