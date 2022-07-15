package com.example.training.domain.service;

import com.example.training.domain.model.ExerciseSet;
import com.example.training.domain.port.ExerciseSetRepository;
import com.example.training.domain.port.TrainingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainingProcessor implements TrainingService {

    private final ExerciseSetRepository repository;

    @Override
    public Long addSet(ExerciseSet exerciseSet) {
        return repository.saveExerciseSet(exerciseSet);
    }
}
