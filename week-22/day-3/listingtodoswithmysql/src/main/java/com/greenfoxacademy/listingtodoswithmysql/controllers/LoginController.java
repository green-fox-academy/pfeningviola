package com.greenfoxacademy.listingtodoswithmysql.controllers;

import com.greenfoxacademy.listingtodoswithmysql.models.User;
import com.greenfoxacademy.listingtodoswithmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
  public String login(@ModelAttribute User userFromForm, Model model){
    if (userService.checkExistUserByName(userFromForm.getName())) {
      if(userService.checkCorrectPassword(userFromForm)) {
        User user = userService.findByName(userFromForm.getName());
        return "redirect:/" + user.getUserId() + "/todo/";
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
  public String register(Model model, @ModelAttribute User userFromForm){
    if (userService.checkExistUserByName(userFromForm.getName())){
      model.addAttribute("alreadyExistingUser", "This username is already used. Choose other name!");
      return "login";
    } else {
        userService.save(userFromForm);
        return "redirect:/" + userFromForm.getUserId() + "/todo/";
    }
  }
}
