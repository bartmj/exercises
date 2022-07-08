package com.example.exercises.adapters.rest.dtos;

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
        Set<String> muscleGroup;
//        @NotEmpty
//        HashSet<String> supportMuscleGroup;


        public ExerciseDto(String name, String engName, Set<String> muscleGroup) {
                this.name = name;
                this.engName = engName;
                this.muscleGroup = muscleGroup;
        }
}