package com.greenfoxacademy.onlinetodo.controllers;

import com.greenfoxacademy.onlinetodo.models.User;
import com.greenfoxacademy.onlinetodo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
  private UserService userService;

  @Autowired
  public LoginController(UserService userService){
    this.userService = userService;
  }

  @GetMapping("/")
  public String renderWelcomePage (){
    return "welcome";
  }

  @GetMapping("/login")
  public String renderLoginPage(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute User user, Model model){
    if (userService.checkExistUser(user)) {
      if(userService.checkCorrectPassword(user)) {
        return "redirect:/todo/?name=" + user.getName();
      } else {
        model.addAttribute("wrongPassword", "The password is not correct.");
        return "login";
      }
    } else {
      model.addAttribute("noUser", "You have provided an username that is not registered.");
      return "login";
    }
  }

  @GetMapping("/register")
  public String renderRegisterPage(){
    return "login";
  }

  @PostMapping("/register")
  public String register(Model model, @ModelAttribute User user, @ModelAttribute(value = "name") String name, @ModelAttribute(value = "password") String password){
    if (userService.checkExistUser(user)){
      model.addAttribute("alreadyExistingUser", "This username is already used. Choose other name!");
      return "login";
    } else {
      try {
        userService.createUser(name, password);
        return "redirect:/todo/?name=" + name;
      }catch (IllegalArgumentException e) {
        return "redirect:/error";
      }
    }

  }
}



