package com.example.exercises.adapters.rest.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ExerciseDto {

        @NotBlank
        String name;
        @NotBlank
        String engName;
        @NotEmpty
        Set<String> mainMuscleGroup;
        @NotEmpty
        Set<String> supportMuscleGroup;

        public ExerciseDto(String name, String engName, Set<String> mainMuscleGroup, Set<String> supportMuscleGroup) {
                this.name = name;
                this.engName = engName;
                this.mainMuscleGroup = mainMuscleGroup;
                this.supportMuscleGroup = supportMuscleGroup;
        }

}