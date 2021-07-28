package com.igorpdev.restfulapi.dto;

import java.time.LocalDate;

import com.igorpdev.restfulapi.model.User;

public class UserResponseDTO {
    
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

    private UserResponseDTO(Long id, String name, String email, String cpf, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public static UserResponseDTO dtoResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), 
        user.getCpf(), user.getBirthDate());
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
