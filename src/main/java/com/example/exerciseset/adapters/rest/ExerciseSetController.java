package com.example.exerciseset.adapters.rest;

import com.example.exercises.domain.model.Exercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public class ExerciseSetController {

    @PostMapping
    public ResponseEntity<String> addSet(@Valid @RequestBody Exercise exercise,
            @NotNull int reps, @NotNull int weight) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Set has been added");
    }
}
