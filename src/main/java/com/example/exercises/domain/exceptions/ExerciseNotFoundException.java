package com.example.exercises.domain.exceptions;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException() {
        super("Exercise not found");
    }
}
