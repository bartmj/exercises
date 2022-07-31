package com.example.exercises.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
public class ExerciseSetDto {

    Long id;
    String exerciseName;
    Long userId;
    int reps;
    int weight;
    String comment;

}
