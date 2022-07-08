package com.example.exercises.adapters.persistence.adapters;

import com.example.exercises.adapters.persistence.mappers.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repositories.JpaExerciseRepository;
import com.example.exercises.test.tools.TestTools;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExercisePersistenceAdapterTest {

    @Mock
    private JpaExerciseRepository jpaExerciseRepository;
    @Mock
    private ExercisePersistenceMapper exercisePersistenceMapper;
    @InjectMocks
    private ExercisePersistenceAdapter persistenceAdapter;

    @Test
    public void saveExercise_shouldReturn_IdOf1L() throws Exception {
        var validExercise = TestTools.createValidExercise();
        var exerciseEntity = exercisePersistenceMapper.toEntity(validExercise);
        var exerciseEntityFromDb = TestTools.createValidExerciseEntity();

        when(exercisePersistenceMapper.toEntity(validExercise)).thenReturn(exerciseEntity);
        when(jpaExerciseRepository.save(exerciseEntity)).thenReturn(exerciseEntityFromDb);

        var aLong = persistenceAdapter.saveExercise(validExercise);
        assertEquals(1L, aLong);
    }

}