package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FoxService {

  private FoxRepository foxRepository;
  private NutritionTimerService nutritionTimerService;

  @Autowired
  public FoxService(FoxHashMapRepository foxRepository, NutritionTimerService nutritionTimerService) {
    this.foxRepository = foxRepository;
    this.nutritionTimerService = nutritionTimerService;
  }

  public boolean checkExistUser(String name){
    return foxRepository.findAll().containsKey(name);
  }

  public void createFox(String name, String filename){
    if (!foxRepository.findAll().containsKey(name)) {
      Fox newFox = new Fox(name, filename);
      foxRepository.save(newFox);
      nutritionTimerService.decreaseFoodLevel(name);
    }
  }

  public Fox findByName(String name){
    return foxRepository.findByName(name);
  }

  public HashMap<String, Fox> findAll(){
    return foxRepository.findAll();
  }

  public void changeNutrition(String name, String food, String drink) {
    Fox fox = findByName(name);
    fox.setFood(food);
    fox.setDrink(drink);
  }

  public void changeImage(String name, String filename){
    Fox fox = findByName(name);
    fox.setFilename(filename);
  }
}
