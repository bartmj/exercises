package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import com.example.exercises.domain.model.ExerciseSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ExerciseSetPersistenceMapperResolver.class)
public interface ExerciseSetPersistenceMapper {

    @Mapping(source = "exerciseId", target = "exerciseEntity")
    @Mapping(source = "userId", target = "usersEntity")
    ExerciseSetEntity toEntity(ExerciseSet exercise);

    @Mapping(source = "exerciseEntity", target = "exerciseId")
    @Mapping(source = "usersEntity", target = "userId")
    ExerciseSet toDomain(ExerciseSetEntity exerciseEntity);

}
