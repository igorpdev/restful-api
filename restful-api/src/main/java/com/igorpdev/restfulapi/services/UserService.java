package com.igorpdev.restfulapi.services;

import java.util.Optional;

import com.igorpdev.restfulapi.model.User;
import com.igorpdev.restfulapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User findByCpf(String cpf) {
      Optional<User> obj = userRepository.findByCpf(cpf);
      return obj.get();
    }

    public Optional<User> create(User user){
      return Optional.of(userRepository.save(user));
    }

    public void deleteByCpf(String cpf) {
        userRepository.deleteByCpf(cpf);
    }
}
