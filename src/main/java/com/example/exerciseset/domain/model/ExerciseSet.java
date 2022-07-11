package com.example.exerciseset.domain.model;


import com.example.exercises.domain.model.Exercise;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ExerciseSet {

    @Valid
    private Exercise exercise;
    @NotNull
    private int reps;
    @NotNull
    private int weight;

}
