package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.adapters.rest.mappers.ExerciseRestMapper;
import com.example.exercises.domain.services.ExerciseProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseProcessor questService;
    private final ExerciseRestMapper exerciseRestMapper;


    @PostMapping("/add")
    public ResponseEntity<Long> sendExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
        var exercise = exerciseRestMapper.toDomain(exerciseDto);
        var aLong = questService.saveExercise(exercise);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(aLong);
    }

}
