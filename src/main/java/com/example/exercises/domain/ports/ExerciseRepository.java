package com.example.exercises.domain.ports;

import com.example.exercises.domain.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {

    Long saveExercise(Exercise exercise);

    List<Exercise> getAll();

    Optional<Exercise> findById(Long id);
}
