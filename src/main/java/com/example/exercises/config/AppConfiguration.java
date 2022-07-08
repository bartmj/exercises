package com.example.exercises.config;

import com.example.exercises.domain.ports.ExerciseRepository;
import com.example.exercises.domain.services.ExerciseProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "questService")
    public ExerciseProcessor getExerciseProcessor(ExerciseRepository exerciseRepository){
        return new ExerciseProcessor(exerciseRepository);
    }
}
