package com.greenfoxacademy.programmersfoxclub.controllers;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService){
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String renderUserPage(Model model, @RequestParam String name) {
    Fox fox = foxService.login(name);

    model.addAttribute("fox", fox);
    return "index";
  }

  @GetMapping("/login")
  public String renderLoginPage(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String name){
    return "redirect:/?name=" + name;
  }
}
