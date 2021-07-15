package com.igorpdev.restfulapi.repositories;

import com.igorpdev.restfulapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByCpf(String cpf);
}
