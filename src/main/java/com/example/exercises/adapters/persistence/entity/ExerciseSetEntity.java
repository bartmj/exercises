package com.example.exercises.adapters.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "exerciseset")
public class ExerciseSetEntity {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private UsersEntity usersEntity;
    @ManyToOne
    private ExerciseEntity exerciseEntity;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private Integer reps;
    private Integer weight;

}

