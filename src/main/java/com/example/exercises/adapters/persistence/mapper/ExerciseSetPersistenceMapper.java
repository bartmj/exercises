package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import com.example.exercises.domain.model.ExerciseSet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseSetPersistenceMapper {

    ExerciseSetEntity toEntity(ExerciseSet exercise);

    ExerciseSet toDomain(ExerciseSetEntity exerciseEntity);

}
