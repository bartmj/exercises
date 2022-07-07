package com.example.exercises.domain.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;

public class Exercise {

    @NotBlank
    private String name;
    @NotBlank
    private String engName;
    @NotEmpty
    private HashSet<String> muscleGroup;
}
