package com.example.exercises.domain.port;

import com.example.exercises.domain.model.Users;

public interface UsersRepository {

    Users findById(Long id);
}
