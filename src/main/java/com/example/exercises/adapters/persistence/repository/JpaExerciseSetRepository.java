package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface JpaExerciseSetRepository extends JpaRepository<ExerciseSetEntity, Long> {

    List<ExerciseSetEntity> findAllById(Long userId);
}
