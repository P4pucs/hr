package com.avinty.hr.controller;

import com.avinty.hr.model.User;
import com.avinty.hr.payload.UserRequest;
import com.avinty.hr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByName(name));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        }
    }

    @GetMapping(path = "getAllCount")
    public ResponseEntity<List<User>> getAllUsersCount() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsersCount());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User updatedUser) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id, updatedUser));
    }
}
