package com.example.training.adapters.persistence;

import com.example.training.adapters.persistence.mapper.ExerciseSetPersistenceMapper;
import com.example.training.adapters.persistence.repository.JpaExerciseSetRepository;
import com.example.training.domain.model.ExerciseSet;
import com.example.training.domain.port.ExerciseSetRepository;
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
