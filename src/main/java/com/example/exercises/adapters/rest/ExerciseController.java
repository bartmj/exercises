package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class ExerciseController {

    //TODO inject mappers
    //TODO inject service

    @PostMapping("/exercises")
    ResponseEntity<Long> sendExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
        //TODO implement mappers
        //TODO implement service
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
