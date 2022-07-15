package com.example.training.adapters.rest.mapper;

import com.example.training.adapters.rest.dto.ExerciseSetDto;
import com.example.training.domain.model.ExerciseSet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingRestMapper {

    ExerciseSet toDomain(ExerciseSetDto exerciseDto);

    ExerciseSetDto toDto(ExerciseSet exercise);

}
