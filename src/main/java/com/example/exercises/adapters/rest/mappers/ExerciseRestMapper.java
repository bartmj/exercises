package com.example.exercises.adapters.rest.mappers;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.domain.model.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseRestMapper {

    Exercise toDomain(ExerciseDto exerciseDto);

    ExerciseDto toDto(Exercise exercise);
}
