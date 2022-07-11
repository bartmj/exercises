package com.example.day.domain.model;

import com.example.exercises.domain.model.Exercise;
import com.example.exerciseset.domain.model.ExerciseSet;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TrainingDay {

    private HashMap<UUID, ExerciseSet> exercises;

}
