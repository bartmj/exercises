package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class ExerciseControllerTest {

    public static final String EXERCISES_ADD = "/exercises/add";
    public static final String EXERCISES_GET = "/exercises";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenInputIsInvalid_postShouldReturnsStatus400() throws Exception {
        ExerciseDto exerciseDto = ExerciseDto.builder().build();
        String body = objectMapper.writeValueAsString(exerciseDto);

        mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void givenInputIsValid_postShouldReturnsStatus200() throws Exception {
        var exerciseDto = ExerciseTestTools.createValidExerciseDto();

        String body = objectMapper.writeValueAsString(exerciseDto);

        mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void getAll_shouldReturnsStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(EXERCISES_GET)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

//    @Test
//    void getAll_shouldReturnsListOfExercises() throws Exception {
//
//        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(EXERCISES_GET)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andReturn();
//
//        var contentAsString = mvcResult.getResponse().getContentAsString();
//        var content = objectMapper.readValue(contentAsString, new TypeReference<List<ExerciseDto>>() {
//        });
//        assert(content.get(0).getName().equals("Przysiad ze sztangą"));
//    }

}



