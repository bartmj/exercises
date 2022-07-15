package com.example.exercises.domain.port;

import com.example.exercises.domain.model.ExerciseSet;

public interface ExerciseSetRepository {

    Long saveExerciseSet(ExerciseSet exerciseSet);
}
