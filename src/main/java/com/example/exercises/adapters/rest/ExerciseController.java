package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dto.ExerciseDto;
import com.example.exercises.adapters.rest.mapper.ExerciseRestMapper;
import com.example.exercises.domain.service.ExerciseProcessor;
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

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Long> sendExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
        var exercise = exerciseRestMapper.toDomain(exerciseDto);
        var aLong = service.saveExercise(exercise);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(aLong);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ExerciseDto>> getAllExercises() {
        var exercises = service.getAll();
        var exerciseDtos = exerciseRestMapper.toDto(exercises);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseDtos);
    }

    @GetMapping(value = "/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ExerciseDto> findById(@PathVariable Long id) {
        var exercise = service.findById(id);
        var exerciseDto = exerciseRestMapper.toDto(exercise);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseDto);
    }

}
