package com.example.usermanagementbackend.services;

import com.example.usermanagementbackend.entities.User;
import com.example.usermanagementbackend.exceptions.UserNotFoundException;
import com.example.usermanagementbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserService {
    final UserRepo userRepo;
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User findUser(long id) {
        return (userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by Id " + id + " was not found")));
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}
