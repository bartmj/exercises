package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.adapters.rest.mapper.TrainingRestMapper;
import com.example.exercises.domain.port.TrainingService;
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
@RequiredArgsConstructor
@Validated
@RequestMapping("/training")
public class TrainingController {

    private final TrainingService service;
    private final TrainingRestMapper mapper;

    @PostMapping
    public ResponseEntity<String> addSet(@Valid @RequestBody ExerciseSetDto exerciseSetDto) {
        var exerciseSet = mapper.toDomain(exerciseSetDto);
        var setId = service.addSet(exerciseSet);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("Set with id %s added.", setId));
    }
}
