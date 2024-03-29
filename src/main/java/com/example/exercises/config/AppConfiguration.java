package com.example.exercises.config;

import com.example.exercises.domain.port.ExerciseRepository;
import com.example.exercises.domain.port.ExerciseService;
import com.example.exercises.domain.port.ExerciseSetRepository;
import com.example.exercises.domain.port.TrainingService;
import com.example.exercises.domain.service.ExerciseProcessor;
import com.example.exercises.domain.service.TrainingProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "exerciseService")
    public ExerciseProcessor getExerciseProcessor(ExerciseRepository exerciseRepository){
        return new ExerciseProcessor(exerciseRepository);
    }

    @Bean(name = "trainingService")
    public TrainingService getTrainingProcessor(ExerciseSetRepository exerciseSetRepository){
        return new TrainingProcessor(exerciseSetRepository);
    }

}
