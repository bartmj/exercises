package com.example.training.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ExerciseSetDto {

    private long exerciseId;
    private long userId;
    private int reps;
    private int weight;
}
