package com.igorpdev.restfulapi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.igorpdev.restfulapi.model.User;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

public class UserDTO {
    
    @NotBlank(message = "The Name field is required")
    private String name;

    @Email
    @NotBlank(message = "The Email field is required")
    private String email;

    @CPF
    @NotBlank(message = "The CPF field is required")
    private String cpf;

    private LocalDate birthDate;

    public User userToDto() {
        return new User(name, email, cpf, birthDate);
    }

    @Component
	public class LocalDateSpringConverter implements Converter<String, LocalDate> {

		@Override
		public LocalDate convert(String value) {
			if (value != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				return LocalDate.parse(value, formatter);
			} else {
				return null;
			}
		}

        @Override
        public JavaType getInputType(TypeFactory typeFactory) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public JavaType getOutputType(TypeFactory typeFactory) {
            // TODO Auto-generated method stub
            return null;
        }
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

