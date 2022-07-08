package com.example.exercises.domain.ports;

import com.example.exercises.domain.model.Exercise;

public interface ExerciseRepository {

    Long saveExercise(Exercise exercise);

}
