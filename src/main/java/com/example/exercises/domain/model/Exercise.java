package com.example.exercises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class Exercise {

    String name;
    String engName;
    Set<String> muscleGroup;
//    HashSet<String> supportMuscleGroup;

    public Exercise(String name, String engName, Set<String> muscleGroup) {
        this.name = name;
        this.engName = engName;
        this.muscleGroup = muscleGroup;
    }
}
