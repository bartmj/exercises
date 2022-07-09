package com.example.exercises.adapters.persistence.adapters;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.adapters.persistence.mappers.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repositories.JpaExerciseRepository;
import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExercisePersistenceAdapter implements ExerciseRepository {

    private final JpaExerciseRepository jpaExerciseRepository;
    private final ExercisePersistenceMapper mapper;

    @Override
    public Long saveExercise(Exercise exercise) {
        var exerciseEntity = mapper.toEntity(exercise);
        var savedEntity = jpaExerciseRepository.save(exerciseEntity);
        return savedEntity.getId();
    }

    @Override
    public List<Exercise> getAll() {
        var exerciseEntities = jpaExerciseRepository.findAll();
        var exercises = mapper.toDomain(exerciseEntities);
        return exercises;
    }
}
