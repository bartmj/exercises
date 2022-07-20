package com.example.exercises.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ExerciseSetDto {

    Long exerciseId;
    Long userId;
    int reps;
    int weight;

    public ExerciseSetDto(Long exerciseId, Long userId, int reps, int weight) {
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.reps = reps;
        this.weight = weight;
    }
}
