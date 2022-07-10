package com.example.exercises.integration;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostExerciseUseCaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExerciseRepository repository;

    @Test
    void postExercise_returns_statusCode201() throws Exception {
        var validExerciseDto = ExerciseTestTools.createValidExerciseDto();

        mockMvc.perform(MockMvcRequestBuilders.post("/exercises/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validExerciseDto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(201));

    }

}
