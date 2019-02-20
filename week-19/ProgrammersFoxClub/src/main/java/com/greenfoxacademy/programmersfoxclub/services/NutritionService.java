package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Action;
import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class NutritionService {
  private FoxRepository foxRepository;
  private NutritionRepository nutritionRepository;

  @Autowired
  public NutritionService(FoxHashMapRepository foxRepository, NutritionRepository nutritionRepository) {
    this.foxRepository = foxRepository;
    this.nutritionRepository = nutritionRepository;
  }

  public void changeNutrition(String name, String food, String drink) {
    Fox fox = foxRepository.findByName(name);
    ArrayList<Action> actionHistory = fox.findAllActionHistory();
    actionHistory.add(new Action(LocalDateTime.now(), "Food has been changed from: " + fox.getFood() + " to: " + food));
    fox.setFood(food);
    actionHistory.add(new Action(LocalDateTime.now(), "Drink has been changed from: " + fox.getDrink() + " to: " + drink));
    fox.setDrink(drink);
    fox.setActionHistory(actionHistory);
  }

  public ArrayList<String> findAllDrink() {
    return nutritionRepository.findAllDrink();
  }

  public ArrayList<String> findAllFood() {
    return nutritionRepository.findAllFood();
  }
}
