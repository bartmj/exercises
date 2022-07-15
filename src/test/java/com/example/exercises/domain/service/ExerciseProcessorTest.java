package com.example.exercises.domain.service;

import com.example.exercises.domain.port.ExerciseRepository;
import com.example.exercises.test.tools.ExerciseTestTools;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseProcessorTest {

    @Mock
    private ExerciseRepository exerciseRepository;
    @InjectMocks
    private ExerciseProcessor exerciseService;

    @Test
    public void saveExercise_shouldReturn_IdOf1L() throws Exception {
        var exercise = ExerciseTestTools.createValidExercise();

        when(exerciseRepository.saveExercise(exercise)).thenReturn(1L);

        var aLong = exerciseService.saveExercise(exercise);
        assertEquals(aLong, 1L);
    }

    @Test
    public void getAll_shouldReturn_listOfDomainExercises() {
        var exerciseList = ExerciseTestTools.createExerciseList();

        when(exerciseRepository.getAll()).thenReturn(exerciseList);

        var exercises = exerciseService.getAll();

        assertAll(
                () -> assertEquals(exercises.get(0).getName(), "Przysiad ze sztangą"),
                () -> assertEquals(exercises.get(0).getEngName(), "Squat with a barbell"),
                () -> assertEquals(exercises.get(0).getMainMuscleGroup(), new HashSet<>(Arrays.asList("czworogłowy uda"))),
                () -> assertEquals(exercises.get(0).getSupportMuscleGroup(), new HashSet<>(Arrays.asList("dwugłowy uda", "pośladkowy")))
        );
    }
}