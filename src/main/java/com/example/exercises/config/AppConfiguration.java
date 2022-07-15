package com.example.exercises.config;

import com.example.exercises.domain.port.ExerciseRepository;
import com.example.exercises.domain.service.ExerciseProcessor;
import com.example.training.domain.port.ExerciseSetRepository;
import com.example.training.domain.service.TrainingProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "exerciseService")
    public ExerciseProcessor getExerciseProcessor(ExerciseRepository exerciseRepository){
        return new ExerciseProcessor(exerciseRepository);
    }
}
