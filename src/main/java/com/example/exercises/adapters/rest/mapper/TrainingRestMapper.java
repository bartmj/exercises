package com.example.exercises.adapters.rest.mapper;

import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.domain.model.ExerciseSet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingRestMapper {

    ExerciseSet toDomain(ExerciseSetDto exerciseDto);

    ExerciseSetDto toDto(ExerciseSet exercise);

}
