package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.User;
import com.qa.exerciseapp.dto.UserDTO;
import com.qa.exerciseapp.exceptions.UserNotFoundException;
import com.qa.exerciseapp.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(UserRepository repo, ModelMapper mapper) {
        this.userRepository = repo;
        this.mapper = mapper;
    }

    private UserDTO mapToDTO(User user) {
        return this.mapper.map(user, UserDTO.class);
    }

    public List<UserDTO> readAllUsers() {
        return this.userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UserDTO createUser(User user) {
        return this.mapToDTO(this.userRepository.save(user));
    }

    public UserDTO findUserById(Long id) {
        return this.mapToDTO(this.userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    public UserDTO updateUser(Long id, User user) {
        User update = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        update.setFirstName(user.getFirstName());
        update.setLastName(user.getLastName());
        update.setEmail(user.getEmail());
        update.setPassword(user.getPassword());
        update.setHeight(user.getHeight());
        update.setWeight(user.getWeight());
        return this.mapToDTO(this.userRepository.save(update));
    }

    public boolean deleteUserById(Long id) {
        if(!this.userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        this.userRepository.deleteById(id);
        return this.userRepository.existsById(id);
    }
}

