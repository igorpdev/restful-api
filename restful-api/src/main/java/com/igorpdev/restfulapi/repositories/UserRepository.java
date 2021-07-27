package com.igorpdev.restfulapi.repositories;

import java.util.Optional;

import com.igorpdev.restfulapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
