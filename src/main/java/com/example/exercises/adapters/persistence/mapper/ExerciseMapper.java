package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface ExerciseMapper {

    ExerciseEntity toEntity(Long id);
}
