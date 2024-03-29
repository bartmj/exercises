package com.example.exercises.adapters.rest.mapper;

import com.example.exercises.adapters.rest.dto.ExerciseDto;
import com.example.exercises.domain.model.Exercise;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseRestMapper {

    Exercise toDomain(ExerciseDto exerciseDto);

    ExerciseDto toDto(Exercise exercise);

    @IterableMapping(elementTargetType = ExerciseDto.class)
    List<ExerciseDto> toDto(List<Exercise> exercises);
}
