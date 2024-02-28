package com.example.demokorneuev.Controller;

import com.example.demokorneuev.Entity.UserEntity;
import com.example.demokorneuev.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
  private final UserService userService;
  @GetMapping("/login")
  public String registerUser(){return "index";}
   @GetMapping("/all")
   public String getAllUser(Model model){
    model.addAttribute("users", userService.getAllUser());
    return "index";
    }
    @PostMapping("/add")
    public String addUser(UserEntity user){
    userService.addUser(user);
    return "redirect:/all";
  }
  @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable Long id){
    userService.deleteById(id);
    return "redirect:/all";
  }
  @GetMapping("/profile")
  public String profileUser(Model model){
    Authentication user = SecurityContextHolder.getContext().getAuthentication();
    model.addAttribute("users", userService.findByUsername(user.getName()));
    return "profile";
  }
}
