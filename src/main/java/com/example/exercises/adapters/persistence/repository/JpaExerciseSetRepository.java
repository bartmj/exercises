package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExerciseSetRepository extends JpaRepository<ExerciseSetEntity, Long> {

}
