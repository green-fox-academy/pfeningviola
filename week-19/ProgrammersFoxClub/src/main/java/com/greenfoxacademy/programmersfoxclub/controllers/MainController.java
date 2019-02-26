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
      String foxName = fox.getName();
      if(fox.isAlive()) {
        return "index";
      } else {
        foxService.findAll().remove(name);
        model.addAttribute("foxName", foxName);
        return "dead-fox";
      }
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
  public String createFox(@ModelAttribute(value = "name") String name, @ModelAttribute(value = "filename") String filename, Model model){
    if (foxService.checkExistUser(name)){
      model.addAttribute("alreadyExistingUser", "With this name already exists a fox. Choose other name!");
      return "create";
    } else {
      try {
        foxService.createFox(name, filename);
        return "redirect:/?name=" + name;
      }catch (IllegalArgumentException e) {
        return "redirect:/error";
      }
    }
  }

  @GetMapping("/nutritionStore")
  public String feedFox(@RequestParam String name, Model model){
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);
    String foxName = fox.getName();

    if (fox.isAlive()) {
      ArrayList<String> possibleFood = nutritionService.findAllFood(name);
      ArrayList<String> possibleDrink = nutritionService.findAllDrink(name);
      model.addAttribute("possibleFood", possibleFood);
      model.addAttribute("possibleDrink", possibleDrink);
      return "nutrition-store";

    } else {
      foxService.findAll().remove(name);
      model.addAttribute("foxName", foxName);
      return "dead-fox";
    }
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
    model.addAttribute("fox", fox);
    String foxName = fox.getName();

    if (fox.isAlive()) {
      ArrayList<String> tricksToLearn = trickService.findTricksToLearn(name);
      model.addAttribute("tricksToLearn", tricksToLearn);
      return "trick-center";
    } else {
      foxService.findAll().remove(name);
      model.addAttribute("foxName", foxName);
      return "dead-fox";
    }
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
    String foxName = fox.getName();

    if (fox.isAlive()) {
      return "action-history";
    } else {
      foxService.findAll().remove(name);
      model.addAttribute("foxName", foxName);
      return "dead-fox";
    }
  }

  @GetMapping("/image")
  public String renderImageChangingPage(@RequestParam String name, Model model) {
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);
    String foxName = fox.getName();

    if (fox.isAlive()) {
      return "change-image";
    } else {
      foxService.findAll().remove(name);
      model.addAttribute("foxName", foxName);
      return "dead-fox";
    }
  }

  @PostMapping("/image")
  public String changeImage(@ModelAttribute(value = "name") String name,
                            @ModelAttribute(value = "filename") String filename){
    foxService.changeImage(name, filename);
    return "redirect:/?name=" + name;
  }

  private void initFox(Model model, String name){
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);
  }
}
