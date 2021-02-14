package com.avinty.hr.service;

import com.avinty.hr.model.User;
import com.avinty.hr.payload.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(UserRequest request);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User updateUserById(Long id, UserRequest request);

    List<User> getUsersByName(String fullName);

    List<User> getAllUsersCount();
}
