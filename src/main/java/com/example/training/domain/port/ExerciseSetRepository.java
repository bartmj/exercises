package com.example.training.domain.port;

import com.example.training.domain.model.ExerciseSet;

public interface ExerciseSetRepository {

    Long saveExerciseSet(ExerciseSet exerciseSet);
}
