package com.igorpdev.restfulapi.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.igorpdev.restfulapi.model.User;
import com.igorpdev.restfulapi.repositories.UserRepository;
import com.igorpdev.restfulapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
		Optional<User> user = userService.create(user);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

    @GetMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User putUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String cpf, User user) {
        userService.delete(user);
    }
}
