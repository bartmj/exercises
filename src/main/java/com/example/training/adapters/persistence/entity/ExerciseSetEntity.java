package com.example.training.adapters.persistence.entity;

import com.example.exercises.adapters.persistence.entity.ExerciseEntity;
import com.example.training.domain.model.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "set")
public class ExerciseSetEntity {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ExerciseEntity exercise;
    @ManyToOne
    private UserEntity userEntity;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private Integer reps;
    private Integer weight;

}

