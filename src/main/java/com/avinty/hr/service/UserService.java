package com.avinty.hr.service;

import com.avinty.hr.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User newUser);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User updateUserById(Long id, User updatedUser);

    List<User> getUsersByName(String fullName);
}
