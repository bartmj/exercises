package com.example.exercises.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class ExerciseSet {

    private long exerciseId;
    private long userId;
    private LocalDateTime date;
    private int reps;
    private int weight;
}
