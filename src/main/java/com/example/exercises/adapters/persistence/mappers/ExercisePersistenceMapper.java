package com.example.exercises.adapters.persistence.mappers;


import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.domain.model.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExercisePersistenceMapper {

    ExerciseEntity toEntity(Exercise exercise);

    Exercise toDomain(ExerciseEntity exerciseEntity);

}