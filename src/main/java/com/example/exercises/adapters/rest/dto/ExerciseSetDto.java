package com.example.exercises.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ExerciseSetDto {

    String exerciseName;
    Long userId;
    int reps;
    int weight;

    public ExerciseSetDto(String exerciseName, Long userId, int reps, int weight) {
        this.exerciseName = exerciseName;
        this.userId = userId;
        this.reps = reps;
        this.weight = weight;
    }
}
