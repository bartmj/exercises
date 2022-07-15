package com.example.exercises.domain.port;

import com.example.exercises.domain.model.Exercise;
import java.util.List;

public interface ExerciseService {

    Long saveExercise(Exercise exercise);

    List<Exercise> getAll();

    Exercise getById(Long id);
}
