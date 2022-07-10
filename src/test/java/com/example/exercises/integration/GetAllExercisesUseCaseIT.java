package com.example.exercises.integration;

import com.example.exercises.adapters.rest.dtos.ExerciseDto;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetAllExercisesUseCaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Transactional
    @Test
    void given_DbNotEmpty_getAll_shouldReturnListOfExerciseDtos_withNotEmptyDtos() throws Exception {
        var validExercise = ExerciseTestTools.createValidExercise();
        exerciseRepository.saveExercise(validExercise);

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/exercises")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        var contentAsString = mvcResult.getResponse().getContentAsString();
        var content = objectMapper.readValue(contentAsString, new TypeReference<List<ExerciseDto>>() {
        });

        assertAll(
                () -> assertEquals(content.get(0).getName(), validExercise.getName()),
                () -> assertEquals(content.get(0).getEngName(), validExercise.getEngName()),
                () -> assertEquals(content.get(0).getMainMuscleGroup(), validExercise.getMainMuscleGroup()),
                () -> assertEquals(content.get(0).getSupportMuscleGroup(), validExercise.getSupportMuscleGroup())
        );
    }
}
