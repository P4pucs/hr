package com.avinty.hr.service;

import com.avinty.hr.model.User;
import com.avinty.hr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(Long id) {
        boolean exits = userRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsersByName(String fullName) {
        return userRepository.findByName(fullName);
    }

    @Override
    public void deleteUserById(Long id) {

        boolean exits = userRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUserById(Long id, User updatedUser) {
        boolean exits = userRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        updatedUser.setId(id); // I know the request body contains the id, but the path variable id would be unused

        return userRepository.save(updatedUser);
    }
}
