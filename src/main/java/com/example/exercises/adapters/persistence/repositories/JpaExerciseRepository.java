package com.example.exercises.adapters.persistence.repositories;

import com.example.exercises.adapters.persistence.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
}
