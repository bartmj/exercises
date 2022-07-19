package com.example.exercises.integration;

import com.example.exercises.adapters.rest.dto.ExerciseDto;
import com.example.exercises.domain.port.ExerciseRepository;
import com.example.exercises.domain.port.UsersRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
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


    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Transactional
    @Test
    void given_DbNotEmpty_getAll_shouldReturnListOfExerciseDtos_withNotEmptyDtos() throws Exception {
        var validExercise = ExerciseTestTools.createValidExercise(); // Przysiad ze sztangą

        exerciseRepository.saveExercise(validExercise);
        var size = exerciseRepository.getAll().size();

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/exercises")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        var contentAsString = mvcResult.getResponse().getContentAsString();
        var content = objectMapper.readValue(contentAsString, new TypeReference<List<ExerciseDto>>() {
        });

        assertAll(
                () -> assertEquals(content.get(size - 1).getExerciseName(), validExercise.getExerciseName()),
                () -> assertEquals(content.get(size - 1).getEngName(), validExercise.getEngName()),
                () -> assertEquals(content.get(size - 1).getMainMuscleGroup(), validExercise.getMainMuscleGroup()),
                () -> assertEquals(content.get(size - 1).getSupportMuscleGroup(), validExercise.getSupportMuscleGroup())
        );
    }
}
