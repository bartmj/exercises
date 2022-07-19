package com.example.exercises.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class Exercise {

    String exerciseName;
    String engName;
    Set<String> mainMuscleGroup;
    Set<String> supportMuscleGroup;

    public Exercise(String exerciseName, String engName, Set<String> mainMuscleGroup, Set<String> supportMuscleGroup) {
        this.exerciseName = exerciseName;
        this.engName = engName;
        this.mainMuscleGroup = mainMuscleGroup;
        this.supportMuscleGroup = supportMuscleGroup;
    }
}
