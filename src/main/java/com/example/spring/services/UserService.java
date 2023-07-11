package com.example.spring.services;

import com.example.spring.model.entities.User;
import com.example.spring.repositories.UserRepository;
import com.example.spring.services.exceptions.ResourceNotFoundExecption;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundExecption(userId);
        }

        return userOptional.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User userArgument) {
        try {
            User userPersistence = userRepository.getReferenceById(userArgument.getId());

            updateData(userPersistence, userArgument);

            return userRepository.save(userPersistence);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExecption(userArgument.getId());
        }
    }

    public void deleteUser(long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundExecption(userId);
        }

        userRepository.deleteById(userId);
    }

    public void updateData(User userPersistence, User userArgument) {
        userPersistence.setName(userArgument.getName());
        userPersistence.setEmail(userArgument.getEmail());
        userPersistence.setPhone(userArgument.getPhone());
    }
}
