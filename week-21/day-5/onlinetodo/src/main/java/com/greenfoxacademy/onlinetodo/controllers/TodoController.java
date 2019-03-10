package com.greenfoxacademy.onlinetodo.controllers;

import com.greenfoxacademy.onlinetodo.models.User;
import com.greenfoxacademy.onlinetodo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

  private UserService userService;

  @Autowired
  public TodoController(UserService userService){
    this.userService = userService;
  }

  @GetMapping("/todo")
  public String renderUserPage(Model model, @RequestParam String name){
    User user = userService.findByName(name);
    model.addAttribute("user", user);
    return "todos";
  }
}
