package com.greenfoxacademy.programmersfoxclub.controllers;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.models.PossibleDrink;
import com.greenfoxacademy.programmersfoxclub.models.PossibleFood;
import com.greenfoxacademy.programmersfoxclub.services.FoxService;
import com.greenfoxacademy.programmersfoxclub.services.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

  private FoxService foxService;
  private NutritionService nutritionService;

  @Autowired
  public MainController(FoxService foxService, NutritionService nutritionService){
    this.foxService = foxService;
    this.nutritionService = nutritionService;
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
  public String changeNutritionOfFox(@ModelAttribute(value="name") String name,
                                     @ModelAttribute(value="food") String food,
                                     @ModelAttribute(value="drink") String drink){
    nutritionService.changeNutrition(name, food, drink);
    return "redirect:/?name=" + name;
  }
}
