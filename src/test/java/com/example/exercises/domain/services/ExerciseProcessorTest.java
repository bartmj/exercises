package com.example.exercises.domain.services;

import com.example.exercises.domain.ports.ExerciseRepository;
import com.example.exercises.test.tools.TestTools;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseProcessorTest {

    @Mock
    private ExerciseRepository exerciseRepository;
    @InjectMocks
    private ExerciseProcessor exerciseService;

    @Test
    @DisplayName("")
    public void saveExercise_shouldReturn_IdOf1L() throws Exception {
        var exercise = TestTools.createValidExercise();

        when(exerciseRepository.saveExercise(exercise)).thenReturn(1L);

        var aLong = exerciseService.saveExercise(exercise);
        assertEquals(aLong, 1L);
    }


}