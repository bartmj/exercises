//package com.example.exercises.adapters.persistence;
//
//import com.example.exercises.adapters.persistence.entity.UserEntity;
//import com.example.exercises.adapters.persistence.mapper.UserPersistenceMapper;
//import com.example.exercises.adapters.persistence.repository.JpaUserRepository;
//import com.example.exercises.domain.exception.UserNotFoundException;
//import com.example.exercises.domain.model.User;
//import com.example.exercises.domain.port.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class UserPersistenceAdapter implements UserRepository {
//
//    private final JpaUserRepository jpaUserRepository;
//    private final UserPersistenceMapper mapper;
//
//    @Override
//    public User findById(Long id) {
//        var userEntity = jpaUserRepository.findById(id)
//                .orElseThrow(UserNotFoundException::new);
//
//    }
//}
