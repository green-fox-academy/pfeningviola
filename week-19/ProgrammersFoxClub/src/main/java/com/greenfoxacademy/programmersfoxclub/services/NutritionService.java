package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionService {
  private FoxRepository foxRepository;

  @Autowired
  public NutritionService(FoxHashMapRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public void changeNutrition(String name, String food, String drink) {
    Fox fox = foxRepository.findByName(name);
    fox.setFood(food);
    fox.setDrink(drink);
  }
}
