package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.User;
import com.qa.exerciseapp.exceptions.UserNotFoundException;
import com.qa.exerciseapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repo) { this.userRepository = repo; }

    public List<User> readAllUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Long id, User user) {
        User update = findUserById(id);
        update.setFirstName(user.getFirstName());
        update.setLastName(user.getLastName());
        update.setEmail(user.getEmail());
        update.setPassword(user.getPassword());
        update.setHeight(user.getHeight());
        update.setWeight(user.getWeight());
        return this.userRepository.save(update);
    }

    public boolean deleteUserById(Long id) {
        if(this.userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        this.userRepository.deleteById(id);
        return this.userRepository.existsById(id);
    }
}

