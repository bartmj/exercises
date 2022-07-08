package com.example.exercises.adapters.persistence.adapters;

import com.example.exercises.adapters.persistence.mappers.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repositories.JpaExerciseRepository;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExercisePersistenceAdapter implements ExerciseRepository {

    private final JpaExerciseRepository jpaExerciseRepository;
    private final ExercisePersistenceMapper exercisePersistenceMapper;

    @Override
    public Long saveExercise(Exercise exercise) {
        var exerciseEntity = exercisePersistenceMapper.toEntity(exercise);
        var savedEntity = jpaExerciseRepository.save(exerciseEntity);
        return savedEntity.getId();
    }
}
