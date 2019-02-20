package com.greenfoxacademy.programmersfoxclub.controllers;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.services.FoxService;
import com.greenfoxacademy.programmersfoxclub.services.NutritionService;
import com.greenfoxacademy.programmersfoxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

  private FoxService foxService;
  private NutritionService nutritionService;
  private TrickService trickService;

  @Autowired
  public MainController(FoxService foxService, NutritionService nutritionService, TrickService trickService){
    this.foxService = foxService;
    this.nutritionService = nutritionService;
    this.trickService = trickService;
  }

  @GetMapping("/")
  public String renderUserPage(Model model, @RequestParam(required = false) String name) {
    if (name == null) {
      return "welcome";
    } else {
      Fox fox = foxService.findByName(name);
      model.addAttribute("fox", fox);
      return "index";
    }
  }

  @GetMapping("/login")
  public String renderLoginPage(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String name, Model model){
    if (foxService.checkExistUser(name)) {
      return "redirect:/?name=" + name;
    } else {
      model.addAttribute("noUser", "You have provided a name that has not been used before.");
      return "login";
    }
  }

  @GetMapping("/create")
  public String renderCreatePage(){
    return "create";
  }

  @PostMapping("/create")
  public String createFox(@ModelAttribute(value = "name") String name, Model model){
    if (foxService.checkExistUser(name)){
      model.addAttribute("alreadyExistingUser", "With this name already exists a fox. Choose other name!");
      return "create";
    } else {
      foxService.createFox(name);
      return "redirect:/?name=" + name;
    }
  }

  @GetMapping("/nutritionStore")
  public String feedFox(@RequestParam String name, Model model){
    Fox fox = foxService.findByName(name);
    ArrayList<String> possibleFood = nutritionService.findAllFood();
    ArrayList<String> possibleDrink = nutritionService.findAllDrink();

    model.addAttribute("fox", fox);
    model.addAttribute("possibleFood", possibleFood);
    model.addAttribute("possibleDrink", possibleDrink);
    return "nutrition-store";
  }

  @PostMapping("/nutritionStore")
  public String changeNutritionOfFox(@ModelAttribute(value="name") String name,
                                     @ModelAttribute(value="food") String food,
                                     @ModelAttribute(value="drink") String drink){
    nutritionService.changeNutrition(name, food, drink);
    return "redirect:/?name=" + name;
  }

  @GetMapping("/trickCenter")
  public String renderTrickCenter(@RequestParam String name, Model model) {
    Fox fox = foxService.findByName(name);
    ArrayList<String> tricksToLearn = trickService.findTricksToLearn(name);

    model.addAttribute("fox", fox);
    model.addAttribute("tricksToLearn", tricksToLearn);
    return "trick-center";
  }

  @PostMapping("/trickCenter")
  public String learnTrick(@ModelAttribute(value="name") String name,
                           @ModelAttribute(value="trick") String trick){
    trickService.learnTrick(name, trick);
    return "redirect:/?name=" + name;
  }

  @GetMapping("/actionHistory")
  public String renderActionHistory(@RequestParam String name, Model model) {
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);

    return "action-history";
  }
}
