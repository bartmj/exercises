package com.example.exercises.domain.services;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import com.example.exercises.domain.ports.ExerciseService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExerciseProcessor implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public Long saveExercise(Exercise exercise) {
        return exerciseRepository.saveExercise(exercise);
    }

    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.getAll();
    }
}
