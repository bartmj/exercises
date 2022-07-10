package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.adapters.rest.mappers.ExerciseRestMapper;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.services.ExerciseProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseProcessor service;
    private final ExerciseRestMapper exerciseRestMapper;


    @PostMapping("/add")
    public ResponseEntity<Long> sendExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
        var exercise = exerciseRestMapper.toDomain(exerciseDto);
        var aLong = service.saveExercise(exercise);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(aLong);
    }

    @GetMapping(produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ExerciseDto>> getAllExercises() {
        var exercises = service.getAll();
        var exerciseDtos = exerciseRestMapper.toDto(exercises);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDto> findById(@PathVariable Long id) {
        var exercise = service.getById(id);
        var exerciseDto = exerciseRestMapper.toDto(exercise);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseDto);
    }

}
