package com.example.training.adapters.persistence.repository;

import com.example.training.adapters.persistence.entity.ExerciseSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExerciseSetRepository extends JpaRepository<ExerciseSetEntity, Long> {

}
