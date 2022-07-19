package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsersRepository extends JpaRepository<UsersEntity, Long> {
}