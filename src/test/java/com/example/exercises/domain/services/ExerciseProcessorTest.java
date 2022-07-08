package com.example.exercises.domain.services;

import com.example.exercises.domain.model.Exercise;
import com.example.exercises.domain.ports.ExerciseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

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
        var exercise = createValidExercise();

        when(exerciseRepository.saveExercise(exercise)).thenReturn(1L);

        var aLong = exerciseService.saveExercise(exercise);
        assertEquals(aLong, 1L);
    }

    public Exercise createValidExercise() {
        HashSet<String> muscleGroups = new HashSet<>();
        muscleGroups.add("czworogłowy uda");
        return Exercise.builder()
                .name("Przysiad ze sztangą")
                .engName("Squat with a barbell")
                .muscleGroup(muscleGroups)
                .build();

    }

}