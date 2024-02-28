package com.example.demokorneuev.Repo;

import com.example.demokorneuev.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity , Long> {
  UserEntity findByUsername(String username);
}
