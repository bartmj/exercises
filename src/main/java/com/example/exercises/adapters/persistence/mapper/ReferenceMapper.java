package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.domain.model.Exercise;
import org.springframework.stereotype.Component;


@Component
public interface ReferenceMapper {

    Exercise findById(Long id);
}
