package com.example.exercises.adapters.persistence;

import com.example.exercises.adapters.persistence.mapper.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repository.JpaExerciseRepository;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.port.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return mapper.toDomain(exerciseEntities);
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        var exerciseEntityOptional = jpaExerciseRepository.findById(id);
        return exerciseEntityOptional.map(mapper::toDomain);
    }

}
