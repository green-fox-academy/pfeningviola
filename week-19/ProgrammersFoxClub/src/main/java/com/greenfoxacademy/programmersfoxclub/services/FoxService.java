package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxHashMapRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public boolean checkExistUser(String name){
    return foxRepository.findAll().containsKey(name);
  }

  public void createFox(String name, String filename){
    if (!foxRepository.findAll().containsKey(name)) {
      Fox newFox = new Fox(name, filename);
      foxRepository.save(newFox);
    }
  }

  public Fox findByName(String name){
    return foxRepository.findByName(name);
  }

  public void changeNutrition(String name, String food, String drink) {
    Fox fox = findByName(name);
    fox.setFood(food);
    fox.setDrink(drink);
  }
}
