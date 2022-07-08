package com.example.exercises.adapters.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String engName;
    @ElementCollection
    private Set<String> mainMuscleGroup = new HashSet<>();
//    @ElementCollection
//    private Set<String> supportMuscleGroup = new HashSet<>();
}
