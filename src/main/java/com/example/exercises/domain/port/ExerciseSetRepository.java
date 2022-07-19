package com.example.exercises.domain.port;

import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.domain.model.ExerciseSet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseSetRepository {

    Long saveExerciseSet(ExerciseSet exerciseSet);

    ExerciseSet findOne(Long id);

    List<ExerciseSet> findAllByIdAndDate(Long userId, LocalDate date);
}

