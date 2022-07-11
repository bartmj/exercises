package com.example.customer.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

public class Customer {

    @Email
    private String email;
    @NotBlank
    private String name;

}
