package com.example.flightmanagementsystem.controllers;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping(value = "/createUser", consumes = "application/json")
    public String addUser(@RequestBody User newUser) {
        Random rand = new Random();
        Integer resRandom = rand.nextInt((9999 - 100) + 1) + 10;
        String userid = Integer.toString(resRandom);
        newUser.setUserId(userid);
        return userService.addUser(newUser);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable(value = "id") String userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity<String> loginUser(@RequestParam String userId, @RequestParam String password)
            throws InvalidCredentialsException {
        return new ResponseEntity<>(userService.login(userId, password), HttpStatus.FOUND);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/searchUser/{id}")
    // @ExceptionHandler(RecordNotFoundException.class)
    public String searchUserByID(@PathVariable("id") String userId) {
        //userService.viewUser(userId);
        // throw new RecordNotFoundException();
        return userService.viewUser(userId);

    }

    @DeleteMapping("/deleteUser/{id}")
    // @ExceptionHandler(RecordNotFoundException.class)
    public String deleteBookingByID(@PathVariable("id") String userId) {
        return userService.removeUser(userId);
    }
}
