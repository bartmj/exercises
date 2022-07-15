package com.example.training.config;


import com.example.training.domain.port.ExerciseSetRepository;
import com.example.training.domain.service.TrainingProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciseSetConfiguration {
    @Bean(name = "trainingProcessor")
    public TrainingProcessor getTrainingProcessor(ExerciseSetRepository exerciseRepository){
        return new TrainingProcessor(exerciseRepository);
    }
}