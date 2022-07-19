package com.example.exercises.domain.port;

import com.example.exercises.domain.model.ExerciseSet;

import java.time.LocalDate;
import java.util.List;
public interface TrainingService {

    Long addSet(ExerciseSet exerciseSet);

    List<ExerciseSet> findAllByIdAndDate(Long userId, LocalDate localDate);
}
