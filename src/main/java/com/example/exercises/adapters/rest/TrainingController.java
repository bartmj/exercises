package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.adapters.rest.mapper.TrainingRestMapper;
import com.example.exercises.domain.port.TrainingService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/training")
public class TrainingController {

    private final TrainingService service;
    private final TrainingRestMapper mapper;

    @PostMapping
    public ResponseEntity<String> addSet(@Valid @RequestBody ExerciseSetDto exerciseSetDto) {
        var exerciseSet = mapper.toDomain(exerciseSetDto);
        service.addSet(exerciseSet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Set has been added.");
    }

    @GetMapping(value = "/{userId}/{localDateTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExerciseSetDto>> getAllSets(@PathVariable("userId") Long userId,
                                                           @PathVariable("localDateTime") String date) {

        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date);
        } catch (DateTimeParseException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ArrayList<>());
        }
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(new ArrayList<>());

//        LocalDate aDay = LocalDate.of(2022, 8, 23);
//        var dateTimeFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(aDay);

        var exerciseSets = service.findAllByIdAndDate(userId, localDate);
        var exerciseSetDtos = exerciseSets
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exerciseSetDtos);
    }
}


