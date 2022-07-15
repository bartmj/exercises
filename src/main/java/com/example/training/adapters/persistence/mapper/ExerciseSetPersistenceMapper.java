package com.example.training.adapters.persistence.mapper;

import com.example.training.adapters.persistence.entity.ExerciseSetEntity;
import com.example.training.domain.model.ExerciseSet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseSetPersistenceMapper {

    ExerciseSetEntity toEntity(ExerciseSet exercise);

    ExerciseSet toDomain(ExerciseSetEntity exerciseEntity);

}
