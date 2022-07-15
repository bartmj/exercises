package com.example.exercises.adapters.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
    private UserEntity userEntity;
    @ManyToOne
    private ExerciseEntity exerciseEntity;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private Integer reps;
    private Integer weight;

}

