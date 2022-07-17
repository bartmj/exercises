package com.example.exercises.adapters.persistence.repository;

import com.example.exercises.adapters.persistence.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UsersEntity, Long> {
}
