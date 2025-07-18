package com.example.hr.managment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr.managment.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional <UserEntity> findByEmail(String email);
    
}


