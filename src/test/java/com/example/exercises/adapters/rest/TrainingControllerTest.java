package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import com.example.exercises.adapters.rest.mapper.ExerciseRestMapper;
import com.example.exercises.adapters.rest.mapper.TrainingRestMapper;
import com.example.exercises.domain.model.ExerciseSet;
import com.example.exercises.domain.port.TrainingService;
import com.example.exercises.domain.service.ExerciseProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest
class TrainingControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExerciseProcessor exerciseService;
    @MockBean
    private ExerciseRestMapper exerciseRestMapper;
    @MockBean
    private TrainingService service;
    @MockBean
    private TrainingRestMapper trainingRestMapper;

    @Test
    void givenInputIsValid_getShouldReturns_Status200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/2022-07-19"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void givenInputDayIsInValid_getShouldReturns_Status400() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/2022-07"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void givenInputMonthIsInValid_getShouldReturns_Status400() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/2022-0y-01"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void givenInputYearIsInValid_getShouldReturns_Status400() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/20245-01-01"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}