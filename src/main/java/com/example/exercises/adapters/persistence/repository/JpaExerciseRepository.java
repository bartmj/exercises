package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
}
