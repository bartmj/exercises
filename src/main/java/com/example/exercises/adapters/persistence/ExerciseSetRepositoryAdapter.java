package com.example.exercises.adapters.persistence;

import com.example.exercises.adapters.persistence.mapper.ExerciseSetPersistenceMapper;
import com.example.exercises.adapters.persistence.repository.JpaExerciseSetRepository;
import com.example.exercises.domain.model.ExerciseSet;
import com.example.exercises.domain.port.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ExerciseSet findOne(Long id) {
        var referenceById = repository.getReferenceById(id);
        return mapper.toDomain(referenceById);
    }

    @Override
    public List<ExerciseSet> findAllByIdAndDate(Long userId, LocalDate localDate) {
        var from = localDate.atStartOfDay();
        var to = localDate.atStartOfDay().plusDays(1);
        var all = repository.findAllByIdAndDate(userId, from, to);
        return all.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

}
