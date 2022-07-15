package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import com.example.exercises.domain.model.ExerciseSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ExercisePersistenceMapper.class, UserPersistenceMapper.class})
public interface ExerciseSetPersistenceMapper {

    @Mapping(source = "exerciseId", target = "exerciseEntity")
    @Mapping(source = "userId", target = "userEntity")
    ExerciseSetEntity toEntity(ExerciseSet exercise);

    ExerciseSet toDomain(ExerciseSetEntity exerciseEntity);

}
