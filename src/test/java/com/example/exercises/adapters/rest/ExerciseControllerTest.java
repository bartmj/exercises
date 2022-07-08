package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class ExerciseControllerTest {

    public static final String EXERCISES_ADD = "/exercises/add";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
        ExerciseDto exerciseDto = ExerciseDto.builder().build();
        String body = objectMapper.writeValueAsString(exerciseDto);

        var result = mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn();
    }

    @Test
    void whenInputIsValid_thenReturnsStatus200() throws Exception {
        HashSet<String> muscleGroups = new HashSet<>();
        HashSet<String> supportMuscleGroups = new HashSet<>();

        muscleGroups.add("czworogłowy uda");
        supportMuscleGroups.add("dwugłowy uda");
        supportMuscleGroups.add("pośladkowy");

        ExerciseDto exerciseDto = ExerciseDto
                .builder()
                .name("Przysiad ze sztangą")
                .engName("Squat with a Barbell")
                .muscleGroup(muscleGroups)
                .build();

        String body = objectMapper.writeValueAsString(exerciseDto);

        var result = mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }

}



