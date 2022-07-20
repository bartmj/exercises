package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface JpaExerciseSetRepository extends JpaRepository<ExerciseSetEntity, Long> {

    @Query(
            value = "SELECT * FROM exerciseset where users_entity_id = ?1 and local_date_time >= ?2 and local_date_time < ?3",
            nativeQuery = true
    )
    List<ExerciseSetEntity> findAllByIdAndDate(Long userId, LocalDateTime from, LocalDateTime to);
}

