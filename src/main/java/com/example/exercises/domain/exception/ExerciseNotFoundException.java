package com.example.exercises.domain.exception;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException() {
        super("Exercise not found");
    }
}
