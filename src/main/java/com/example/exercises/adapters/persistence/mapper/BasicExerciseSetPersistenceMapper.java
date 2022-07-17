//package com.example.exercises.adapters.persistence.mapper;
//
//import com.example.exercises.adapters.persistence.entity.ExerciseSetEntity;
//import com.example.exercises.adapters.persistence.repository.JpaExerciseRepository;
//import com.example.exercises.adapters.persistence.repository.JpaUserRepository;
//import com.example.exercises.domain.exception.ExerciseNotFoundException;
//import com.example.exercises.domain.exception.UserNotFoundException;
//import com.example.exercises.domain.model.ExerciseSet;
//import com.example.exercises.domain.port.ExerciseSetPersistenceMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//@AllArgsConstructor
//public class BasicExerciseSetPersistenceMapper implements ExerciseSetPersistenceMapper {
//
//    private final JpaExerciseRepository jpaExerciseRepository;
//    private final JpaUserRepository jpaUserRepository;
//
//    @Override
//    public ExerciseSetEntity toEntity(ExerciseSet exerciseSet) {
//
//        var id = jpaUserRepository.findById(exerciseSet.getUserId())
//                .orElseThrow(UserNotFoundException::new);
//        var id1 = jpaExerciseRepository.findById(exerciseSet.getExerciseId())
//                .orElseThrow(ExerciseNotFoundException::new);
//
//        return new ExerciseSetEntity(exerciseSet.getId(),
//                id,
//                id1,
//                LocalDateTime.now(),
//                exerciseSet.getReps(),
//                exerciseSet.getWeight()
//        );
//    }
//
//    @Override
//    public ExerciseSet toDomain(ExerciseSetEntity exerciseEntity) {
//        return ExerciseSet.builder()
//                .id(exerciseEntity.getId())
//                .exerciseId(exerciseEntity.getExerciseEntity().getId())
//                .userId(exerciseEntity.getUserEntity().getId())
//                .date(exerciseEntity.getLocalDateTime())
//                .reps(exerciseEntity.getReps())
//                .weight(exerciseEntity.getWeight())
//                .build();
//    }
//}