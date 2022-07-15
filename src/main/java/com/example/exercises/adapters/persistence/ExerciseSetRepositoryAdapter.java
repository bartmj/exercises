package com.example.exercises.adapters.persistence;

import com.example.exercises.adapters.persistence.mapper.ExerciseSetPersistenceMapper;
import com.example.exercises.adapters.persistence.repository.JpaExerciseSetRepository;
import com.example.exercises.domain.model.ExerciseSet;
import com.example.exercises.domain.port.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseSetRepositoryAdapter implements ExerciseSetRepository {

    private final JpaExerciseSetRepository repository;
    private final ExerciseSetPersistenceMapper mapper;

    @Override
    public Long saveExerciseSet(ExerciseSet exerciseSet) {
        var exerciseSetEntity = mapper.toEntity(exerciseSet);
        var savedEntity = repository.save(exerciseSetEntity);
        return savedEntity.getId();
    }
}
