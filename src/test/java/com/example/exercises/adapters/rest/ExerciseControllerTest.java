package com.example.exercises.adapters.rest;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.adapters.rest.mappers.ExerciseRestMapper;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.services.ExerciseProcessor;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@WebMvcTest
class ExerciseControllerTest {

    public static final String EXERCISES_ADD = "/exercises/add";
    public static final String EXERCISES_GET = "/exercises";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExerciseProcessor questService;
    @MockBean
    private ExerciseRestMapper mapper;

    @Test
    void givenInputIsInvalid_postShouldReturns_Status400() throws Exception {
        ExerciseDto exerciseDto = ExerciseDto.builder().build();
        String body = objectMapper.writeValueAsString(exerciseDto);

        mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void givenInputIsValid_postShouldReturns_Status200() throws Exception {
        var exerciseDto = ExerciseTestTools.createValidExerciseDto();

        String body = objectMapper.writeValueAsString(exerciseDto);

        mockMvc.perform(MockMvcRequestBuilders.post(EXERCISES_ADD)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void getAll_shouldReturn_Status200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(EXERCISES_GET)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getAll_shouldReturn_ListOfExercises() throws Exception {

        var exerciseList = ExerciseTestTools.createExerciseList();

        Mockito.when(questService.getAll()).thenReturn(exerciseList);
        Mockito.when(mapper.toDto(exerciseList)).thenReturn(ExerciseTestTools.createExerciseDtoList());

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(EXERCISES_GET)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        var contentAsString = mvcResult.getResponse().getContentAsString();
        var content = objectMapper.readValue(contentAsString, new TypeReference<List<ExerciseDto>>() {
        });

        assertAll(
                () -> assertEquals(content.get(0).getName(), "Przysiad ze sztangą"),
                () -> assertEquals(content.get(0).getEngName(), "Squat with a barbell"),
                () -> assertEquals(content.get(0).getMainMuscleGroup(), new HashSet<>(Arrays.asList("czworogłowy uda"))),
                () -> assertEquals(content.get(0).getSupportMuscleGroup(), new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")))
        );
    }
}



