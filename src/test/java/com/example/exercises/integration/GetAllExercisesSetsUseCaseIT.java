package com.example.exercises.integration;

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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetAllExercisesSetsUseCaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Transactional
    @Test
    void getAllExerciseSets_withValidUserIdAndDate_returns_status200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/2022-07-19"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Transactional
    @Test
    void getAllExerciseSets_withValidUserIdAndInvalidDate_returns_status404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/training/1/gf234"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}
