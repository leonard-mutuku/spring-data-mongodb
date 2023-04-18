/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.controller;

import com.mongodb.model.User;
import com.mongodb.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leonard
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    @Autowired
    private UserRepository repo;
    
    @GetMapping
    public ResponseEntity getUsers() {
        List<User> users = repo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity getUser(@PathVariable("id") String id) {
        if (repo.existsById(id)) {
            User user = repo.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Not found!");
        }
    }
    
    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        User newUser = repo.save(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    
}
