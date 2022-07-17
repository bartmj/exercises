package com.example.exercises.domain.port;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.domain.model.Exercise;
import java.util.List;

public interface ExerciseService {

    Long saveExercise(Exercise exercise);

    List<Exercise> getAll();

    Exercise findById(Long id);

}

