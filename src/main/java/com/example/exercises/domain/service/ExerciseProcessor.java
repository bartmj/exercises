package com.example.exercises.domain.service;

import com.example.exercises.domain.exception.ExerciseNotFoundException;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.port.ExerciseRepository;
import com.example.exercises.domain.port.ExerciseService;
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

    @Override
    public Exercise getById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(ExerciseNotFoundException::new);
    }
}
