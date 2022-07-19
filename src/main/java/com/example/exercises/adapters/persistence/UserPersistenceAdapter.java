package com.example.exercises.adapters.persistence;

import com.example.exercises.adapters.persistence.mapper.UserPersistenceMapper;
//import com.example.exercises.adapters.persistence.repository.JpaUserRepository;
import com.example.exercises.adapters.persistence.repository.JpaUsersRepository;
import com.example.exercises.domain.exception.UserNotFoundException;
import com.example.exercises.domain.model.Users;
import com.example.exercises.domain.port.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserPersistenceAdapter implements UsersRepository {

    private final JpaUsersRepository jpaUserRepository;
    private final UserPersistenceMapper mapper;

    @Override
    public Users findById(Long id) {
        var userEntity = jpaUserRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return mapper.toDomain(userEntity);
    }
}
