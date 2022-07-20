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

        Long id;
        @NotBlank
        String exerciseName;
        @NotBlank
        String engName;
        @NotEmpty
        Set<String> mainMuscleGroup;
        @NotEmpty
        Set<String> supportMuscleGroup;

        public ExerciseDto(Long id, String exerciseName, String engName, Set<String> mainMuscleGroup, Set<String> supportMuscleGroup) {
                this.id = id;
                this.exerciseName = exerciseName;
                this.engName = engName;
                this.mainMuscleGroup = mainMuscleGroup;
                this.supportMuscleGroup = supportMuscleGroup;
        }
}