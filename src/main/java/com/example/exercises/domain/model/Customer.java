package com.example.exercises.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {

    @Email
    private String email;
    @NotBlank
    private String name;
}
