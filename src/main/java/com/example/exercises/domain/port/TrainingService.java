package com.example.exercises.domain.port;

import com.example.exercises.domain.model.ExerciseSet;

public interface TrainingService {

    Long addSet(ExerciseSet exerciseSet);
}
