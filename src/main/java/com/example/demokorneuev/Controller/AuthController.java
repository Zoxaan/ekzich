package com.example.demokorneuev.Controller;

import com.example.demokorneuev.Entity.UserEntity;
import com.example.demokorneuev.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class AuthController {
  private final UserService userService;
@GetMapping()
  public String loginPage(){return "login";}
  @PostMapping("/registration")
  public String registerForm(UserEntity user){ userService.registerForm(user);
  return "redirect:/login";
  }



}
