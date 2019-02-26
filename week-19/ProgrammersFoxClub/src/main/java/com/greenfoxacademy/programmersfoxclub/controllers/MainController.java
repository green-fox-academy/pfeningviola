package com.greenfoxacademy.programmersfoxclub.controllers;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.ImageRepository;
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
  private ImageRepository imageRepository;

  @Autowired
  public MainController(FoxService foxService, NutritionService nutritionService, TrickService trickService, ImageRepository imageRepository){
    this.foxService = foxService;
    this.nutritionService = nutritionService;
    this.trickService = trickService;
    this.imageRepository =imageRepository;
  }

  @GetMapping("/")
  public String renderUserPage(Model model, @RequestParam(required = false) String name) {
    if (name == null) {
      return "welcome";
    } else {
      Fox fox = foxService.findByName(name);
      model.addAttribute("fox", fox);
      String foxName = fox.getName();
      if (!fox.isAlive()){
        foxService.findAll().remove(name);
        model.addAttribute("foxName", foxName);
        return "dead-fox";
      } else if ((fox.isAlive()) && (!fox.isLearningState())) {
        return "index";
      } else {
        return "redirect:/trickCenter?name=" + name;
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
  public String renderCreatePage(Model model){
    ArrayList<String> foxImages = imageRepository.findAllFoxImages();
    model.addAttribute("foxImages", foxImages);
    return "create";
  }

  @PostMapping("/create")
  public String createFox(@ModelAttribute(value = "name") String name, @ModelAttribute(value = "filename") String filename, Model model){
    if (foxService.checkExistUser(name)){
      model.addAttribute("alreadyExistingUser", "With this name already exists a fox. Choose other name!");
      ArrayList<String> foxImages = imageRepository.findAllFoxImages();
      model.addAttribute("foxImages", foxImages);
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

    if (!fox.isAlive()) {
      return "redirect:/?name=" + name;
    } else if (fox.isLearningState()){
      return "redirect:/trickCenter?name=" + name;
    } else {
      ArrayList<String> possibleFood = nutritionService.findAllFood(name);
      ArrayList<String> possibleDrink = nutritionService.findAllDrink(name);
      model.addAttribute("possibleFood", possibleFood);
      model.addAttribute("possibleDrink", possibleDrink);
      return "nutrition-store";
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

    if (!fox.isAlive()) {
      return "redirect:/?name=" + name;
    } else if (fox.isLearningState()){
      if (foxService.findByName(name).findAllKnownTricks().size() > 0) {
        String actualLearningTrick = foxService.findByName(name).findAllKnownTricks().get(foxService.findByName(name).findAllKnownTricks().size() - 1);
        model.addAttribute("actualLearningTrick", actualLearningTrick);
      }
      return "learning";
    } else {
      ArrayList<String> tricksToLearn = trickService.findTricksToLearn(name);
      model.addAttribute("tricksToLearn", tricksToLearn);
      return "trick-center";
    }
  }

  @PostMapping("/trickCenter")
  public String learnTrick(@ModelAttribute(value="name") String name,
                           @ModelAttribute(value="trick") String trick){
    Fox fox = foxService.findByName(name);
    trickService.learnTrick(name, trick);
    if (fox.isLearningState()){
      return "redirect:/trickCenter?name=" + name;
    } else {
      return "redirect:/?name=" + name;
    }
  }

  @GetMapping("/actionHistory")
  public String renderActionHistory(@RequestParam String name, Model model) {
    Fox fox = foxService.findByName(name);
    model.addAttribute("fox", fox);

    if (!fox.isAlive()) {
      return "redirect:/?name=" + name;
    } else if (fox.isLearningState()){
      return "redirect:/trickCenter?name=" + name;
    } else {
      return "action-history";
    }
  }

  @GetMapping("/image")
  public String renderImageChangingPage(@RequestParam String name, Model model) {
    Fox fox = foxService.findByName(name);
    ArrayList<String> foxImages = imageRepository.findAllFoxImages();
    model.addAttribute("foxImages", foxImages);
    model.addAttribute("fox", fox);

    if (!fox.isAlive()) {
      return "redirect:/?name=" + name;
    } else if (fox.isLearningState()){
      return "redirect:/trickCenter?name=" + name;
    } else {
      return "change-image";
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
