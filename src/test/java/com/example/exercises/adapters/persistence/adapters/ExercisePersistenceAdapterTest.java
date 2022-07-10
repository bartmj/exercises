package com.example.exercises.adapters.persistence.adapters;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import com.example.exercises.adapters.persistence.mappers.ExercisePersistenceMapper;
import com.example.exercises.adapters.persistence.repositories.JpaExerciseRepository;
import com.example.exercises.domain.model.Exercise;
import com.example.exercises.test.tools.ExerciseTestTools;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

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

    @Test
    public void givenExerciseIsInDb_findById_shouldReturn_OptionalOfExercise() {
        var validExerciseEntity = ExerciseTestTools.createValidExerciseEntity();
        var validExercise = ExerciseTestTools.createValidExercise();

        when(jpaExerciseRepository.findById(1L)).thenReturn(Optional.ofNullable(validExerciseEntity));
        when(exercisePersistenceMapper.toDomain(validExerciseEntity)).thenReturn(validExercise);

        var exerciseOptional = persistenceAdapter.findById(1L);
        assertTrue(exerciseOptional.isPresent());
    }

    @Test
    public void givenExerciseIsNotInDb_findById_shouldReturn_EmptyOptionalOfExercise() {

        when(jpaExerciseRepository.findById(1000000000000000L)).thenReturn(Optional.empty());

        var exerciseOptional = persistenceAdapter.findById(1000000000000000L);
        assertTrue(exerciseOptional.isEmpty());
    }


}











