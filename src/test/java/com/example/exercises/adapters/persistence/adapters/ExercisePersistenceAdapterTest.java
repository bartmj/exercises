package com.example.exercises.adapters.persistence.adapters;

import com.example.exercises.adapters.persistence.mappers.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repositories.JpaExerciseRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.HashSet;

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
        var validExercise = ExerciseTestTools.createValidExercise();
        var exerciseEntity = exercisePersistenceMapper.toEntity(validExercise);
        var exerciseEntityFromDb = ExerciseTestTools.createValidExerciseEntity();

        when(exercisePersistenceMapper.toEntity(validExercise)).thenReturn(exerciseEntity);
        when(jpaExerciseRepository.save(exerciseEntity)).thenReturn(exerciseEntityFromDb);

        var aLong = persistenceAdapter.saveExercise(validExercise);
        assertEquals(1L, aLong);
    }

    @Test
    public void getAllExercises_shouldReturnListOfExercises() {

        var exerciseEntitiesList = ExerciseTestTools.createExerciseEntitiesList();
        var exercisesList = ExerciseTestTools.createExerciseList();

        when(jpaExerciseRepository.findAll()).thenReturn(exerciseEntitiesList);
        when(exercisePersistenceMapper.toDomain(exerciseEntitiesList)).thenReturn(exercisesList);

        var exerciseList = persistenceAdapter.getAll();

        assertAll(
                () -> assertEquals(exerciseList.get(0).getName(), "Przysiad ze sztangą"),
                () -> assertEquals(exerciseList.get(0).getEngName(), "Squat with a barbell"),
                () -> assertEquals(exerciseList.get(0).getMainMuscleGroup(), new HashSet<>(Arrays.asList("czworogłowy uda"))),
                () -> assertEquals(exerciseList.get(0).getSupportMuscleGroup(), new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")))
        );
    }
}











