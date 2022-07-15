package com.example.exercises.domain.service;

import com.example.exercises.domain.model.ExerciseSet;
import com.example.exercises.domain.port.ExerciseSetRepository;
import com.example.exercises.domain.port.TrainingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainingProcessor implements TrainingService {

    private final ExerciseSetRepository repository;

    @Override
    public Long addSet(ExerciseSet exerciseSet) {
        return repository.saveExerciseSet(exerciseSet);
    }
}
