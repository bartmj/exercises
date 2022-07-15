package com.example.exercises.adapters.persistence.mapper;

import com.example.exercises.adapters.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface UserPersistenceMapper {
    UserEntity findById(Long id);
}
