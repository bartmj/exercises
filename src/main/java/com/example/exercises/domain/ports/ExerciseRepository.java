package com.example.exercises.domain.ports;

import com.example.exercises.domain.model.Exercise;

import java.util.List;

public interface ExerciseRepository {

    Long saveExercise(Exercise exercise);

    List<Exercise> getAll();
}
