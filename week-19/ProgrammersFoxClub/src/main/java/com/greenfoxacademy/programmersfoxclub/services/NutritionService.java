package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    fox.setFood(food);
    fox.setDrink(drink);
  }

  public ArrayList<String> findAllDrink() {
    return nutritionRepository.findAllDrink();
  }

  public ArrayList<String> findAllFood() {
    return nutritionRepository.findAllFood();
  }
}
