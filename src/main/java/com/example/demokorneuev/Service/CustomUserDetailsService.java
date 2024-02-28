package com.example.demokorneuev.Service;

import com.example.demokorneuev.Entity.UserEntity;
import com.example.demokorneuev.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final PasswordEncoder passwordEncoder;
  private final UserRepo userRepo;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepo.findByUsername(username);
    if (user==null){
      throw new UsernameNotFoundException("Пользователь не найден"+ username);
    }
    List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toList());
   return new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }
}
