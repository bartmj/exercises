package com.example.exercises.adapters.rest.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;

public record ExerciseDto(

        @NotBlank
        String name,
        @NotBlank
        String engName,
        @NotEmpty
        HashSet<String> muscleGroup
) {

}