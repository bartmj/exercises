package com.example.exercises.adapters.rest.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
}
