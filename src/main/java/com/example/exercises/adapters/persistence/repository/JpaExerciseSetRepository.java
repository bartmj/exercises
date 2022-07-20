package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import com.example.exercises.adapters.rest.dto.ExerciseSetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JpaExerciseSetRepository extends JpaRepository<ExerciseSetEntity, Long> {

    @Query(value = "SELECT e.* FROM exerciseset e where e.id = :userId", nativeQuery = true)
    List<ExerciseSetEntity> findAllById(Long userId);
}
