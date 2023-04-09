package com.cooperatives.produitEtUtilisateurs.services;

import com.cooperatives.produitEtUtilisateurs.models.User;
import com.cooperatives.produitEtUtilisateurs.repository.UserRepository;

import jakarta.inject.Inject;
import java.util.List;

public class UserService {

    @Inject
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id);
        if (existingUser != null) {
            user.setId(id);
            return userRepository.update(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }}
