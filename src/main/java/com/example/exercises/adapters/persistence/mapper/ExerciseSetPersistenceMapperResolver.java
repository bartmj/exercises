package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.exercises.adapters.persistence.entity.UsersEntity;
import com.example.exercises.adapters.persistence.repository.JpaExerciseRepository;
import com.example.exercises.adapters.persistence.repository.JpaUsersRepository;
import com.example.exercises.domain.exception.ExerciseNotFoundException;

import com.example.exercises.domain.exception.UserNotFoundException;
import com.example.exercises.domain.model.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExerciseSetPersistenceMapperResolver {

    private final JpaExerciseRepository jpaExerciseRepository;
    private final JpaUsersRepository jpaUserRepository;

    public ExerciseEntity findExercise(Long id) {
        return jpaExerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
    }

    public UsersEntity findUser(Long id) {
        return jpaUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Long getUserId(UsersEntity usersEntity) {
        return usersEntity.getId();
    }

    public Long getExerciseId(ExerciseEntity exerciseEntity) {
        return exerciseEntity.getId();
    }
}
