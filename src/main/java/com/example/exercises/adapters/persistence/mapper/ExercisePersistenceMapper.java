package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.domain.model.Exercise;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercisePersistenceMapper {

    ExerciseEntity toEntity(Exercise exercise);

    Exercise toDomain(ExerciseEntity exerciseEntity);

    @IterableMapping(elementTargetType = Exercise.class)
    List<Exercise> toDomain(List<ExerciseEntity> entities);

}