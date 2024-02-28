package com.example.demokorneuev.Service;

import com.example.demokorneuev.Entity.Role;
import com.example.demokorneuev.Entity.UserEntity;
import com.example.demokorneuev.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final PasswordEncoder passwordEncoder;
  private final UserRepo userRepo;

  public void registerForm(UserEntity user) {
    user.setUsername(user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRoles(Collections.singleton(Role.USER));
    userRepo.save(user);
  }

  public List<UserEntity> getAllUser() {
    return userRepo.findAll();
  }
  public void deleteById(Long id){  userRepo.deleteById(id);}

  public UserEntity addUser(UserEntity user){ return userRepo.save(user);}

  public UserEntity findByUsername(String username) {
    return userRepo.findByUsername(username);
  }
}
