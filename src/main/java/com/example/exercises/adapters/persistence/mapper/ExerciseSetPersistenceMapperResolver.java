package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.adapters.persistence.entity.UsersEntity;
import com.example.exercises.adapters.persistence.repository.JpaExerciseRepository;
import com.example.exercises.adapters.persistence.repository.JpaUserRepository;
import com.example.exercises.domain.exception.ExerciseNotFoundException;
import com.example.exercises.domain.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExerciseSetPersistenceMapperResolver {

    private final JpaExerciseRepository jpaExerciseRepository;
    private final JpaUserRepository jpaUserRepository;

    public ExerciseEntity findExercise(Long id) {
        return jpaExerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
    }

    public UsersEntity findUser(Long id) {
        return jpaUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
