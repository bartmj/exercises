package com.example.exercises.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class ExerciseSet {

    private Long exerciseId;
    private Long userId;
    private LocalDateTime date;
    private Integer reps;
    private Integer weight;
}