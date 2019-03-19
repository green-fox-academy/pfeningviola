package com.greenfoxacademy.stacktrace.controllers;

import com.greenfoxacademy.stacktrace.models.User;
import com.greenfoxacademy.stacktrace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("new_user", new User());
    model.addAttribute("yolo", userService.getAll());
    return "main";
  }

  @PostMapping("/")
  public String create(@ModelAttribute User user) {
    userService.save(user);
    return "redirect:/app/";
  }
}