package com.example.exercises.adapters.rest.mapper;

import com.example.exercises.adapters.rest.dto.ExerciseDto;
import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.model.ExerciseSet;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingRestMapper {

    ExerciseSet toDomain(ExerciseSetDto exerciseDto);

    ExerciseSetDto toDto(ExerciseSet exercise);

    @IterableMapping(elementTargetType = ExerciseSet.class)
    List<ExerciseSetDto> toDto(List<ExerciseSet> exercises);

}
