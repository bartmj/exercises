package com.example.exercises.test.tools;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.domain.model.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class ExerciseTestTools {

    public static List<Exercise> createExerciseList() {
        List<Exercise> exerciseEntities = new ArrayList<>();
        var validExercise = createValidExercise();
        exerciseEntities.add(validExercise);
        return exerciseEntities;
    }

    public static List<ExerciseEntity> createExerciseEntitiesList() {
        List<ExerciseEntity> exerciseEntities = new ArrayList<>();
        var validExerciseEntity = createValidExerciseEntity();
        exerciseEntities.add(validExerciseEntity);
        return exerciseEntities;
    }

    public static ExerciseEntity createValidExerciseEntity() {
        return new ExerciseEntity(1L,
                "Przysiad ze sztangą",
                "Squat with a barbell",
                new HashSet<>(Arrays.asList("czworogłowy uda")),
                new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")));
    }

    public static Exercise createValidExercise() {
        return Exercise.builder()
                .name("Przysiad ze sztangą")
                .engName("Squat with a barbell")
                .mainMuscleGroup(new HashSet<>(Arrays.asList("czworogłowy uda")))
                .supportMuscleGroup(new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")))
                .build();
    }

    public static ExerciseDto createValidExerciseDto() {
        return ExerciseDto
                .builder()
                .name("Przysiad ze sztangą")
                .engName("Squat with a Barbell")
                .mainMuscleGroup(new HashSet<>(Arrays.asList("czworogłowy uda")))
                .supportMuscleGroup(new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")))
                .build();
    }
}
