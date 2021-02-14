package com.avinty.hr.service;

import com.avinty.hr.model.User;
import com.avinty.hr.payload.UserRequest;
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
    public User createUser(UserRequest request) {
        User user = new User(request.getFullName(), request.getPhoneNumber(), request.getEmail());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()) );
    }

    @Override
    public List<User> getUsersByName(String fullName) {
        return userRepository.findByName(fullName);
    }

    @Override
    public List<User> getAllUsersCount() {
        return userRepository.findAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUserById(Long id, UserRequest request) {
        return userRepository.findById(id).map(user -> {

            user.setFullName(request.getFullName());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setEmail(request.getEmail());

            return userRepository.save(user);
        }).orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

    }
}
