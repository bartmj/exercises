package com.example.exercises.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ExerciseSetDto {

    long exerciseId;
    long userId;
    int reps;
    int weight;

    public ExerciseSetDto(long exerciseId, long userId, int reps, int weight) {
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.reps = reps;
        this.weight = weight;
    }
}
