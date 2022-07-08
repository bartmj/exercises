package com.example.exercises.test.tools;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.domain.model.Exercise;

import java.util.HashSet;

public class TestTools {

    public static ExerciseEntity createValidExerciseEntity() {
        HashSet<String> muscleGroups = new HashSet<>();
        muscleGroups.add("czworogłowy uda");
        return new ExerciseEntity(1L, "Przysiad ze sztangą", "Squat with a barbell", muscleGroups);
    }

    public static Exercise createValidExercise() {
        HashSet<String> muscleGroups = new HashSet<>();
        muscleGroups.add("czworogłowy uda");
        return Exercise.builder()
                .name("Przysiad ze sztangą")
                .engName("Squat with a barbell")
                .muscleGroup(muscleGroups)
                .build();
    }
}
