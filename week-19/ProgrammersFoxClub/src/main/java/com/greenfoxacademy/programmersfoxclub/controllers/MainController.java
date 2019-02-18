package com.greenfoxacademy.programmersfoxclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String renderUserPage(){
    return "index";
  }

  @GetMapping("/login")
  public String renderLoginPage(){
    return "login";
  }
}
