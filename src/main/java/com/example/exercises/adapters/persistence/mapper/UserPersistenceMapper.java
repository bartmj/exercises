package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.adapters.persistence.entity.UsersEntity;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UsersEntity toEntity(Users exercise);

    Users toDomain(UsersEntity exerciseEntity);
}
