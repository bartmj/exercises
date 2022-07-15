package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.test.tools.ExerciseTestTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JpaExerciseRepositoryTest {

    @Autowired
    private JpaExerciseRepository repository;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void save_should_saveExerciseInDb() {
        assertTrue(repository.findAll().isEmpty());
        var validExerciseEntity = ExerciseTestTools.createValidExerciseEntity();
        repository.save(validExerciseEntity);
        assertEquals(1, repository.findAll().size());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void save_should_saveExerciseWithAllFieldsInDb() {
        assertTrue(repository.findAll().isEmpty());
        var validExerciseEntity = ExerciseTestTools.createValidExerciseEntity();
        var savedExerciseEntity = repository.save(validExerciseEntity);
        assertAll(
                () -> assertEquals(savedExerciseEntity.getName(), validExerciseEntity.getName()),
                () -> assertEquals(savedExerciseEntity.getEngName(), validExerciseEntity.getEngName()),
                () -> assertEquals(savedExerciseEntity.getMainMuscleGroup(), validExerciseEntity.getMainMuscleGroup()),
                () -> assertEquals(savedExerciseEntity.getSupportMuscleGroup(), validExerciseEntity.getSupportMuscleGroup())
        );
    }

}