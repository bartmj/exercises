package com.example.exercises.integration;

import com.example.exercises.adapters.persistence.repository.JpaExerciseRepository;
import com.example.exercises.adapters.persistence.repository.JpaUsersRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostExerciseSetUseCaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @Test
    void given_UserWithId1_and_ExerciseWithId1_exist_postExerciseSet_returns_statusCode201() throws Exception {

        var validExerciseSetDto = ExerciseTestTools.createValidExerciseSetDto();
        // WHEN
        mockMvc.perform(MockMvcRequestBuilders.post("/training")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validExerciseSetDto)))
                .andDo(print())
                // THEN
                .andExpect(MockMvcResultMatchers.status().is(201));
    }
}
