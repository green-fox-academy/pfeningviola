package com.greenfoxacademy.programmersfoxclub.controllers;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.models.PossibleDrink;
import com.greenfoxacademy.programmersfoxclub.models.PossibleFood;
import com.greenfoxacademy.programmersfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService){
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String renderUserPage(Model model, @RequestParam String name) {
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);
    return "index";
  }

  @GetMapping("/login")
  public String renderLoginPage(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String name){
    foxService.login(name);
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String feedFox(@RequestParam String name, Model model){
    Fox fox = foxService.findByName(name);
    ArrayList<String> possibleFood = new PossibleFood().getPossibleFood();
    ArrayList<String> possibleDrink = new PossibleDrink().getPossibleDrink();

    model.addAttribute("fox", fox);
    model.addAttribute("possibleFood", possibleFood);
    model.addAttribute("possibleDrink", possibleDrink);
    return "nutrition-store";
  }

  @PostMapping("nutritionStore")
  public String changeNutritionOfFox(@RequestParam(value="name") String name,
                                     @RequestParam(value="food") String food,
                                     @RequestParam(value="drink") String drink){
    foxService.changeNutrition(name, food, drink);
    return "redirect:/?name=" + name;
  }
}
