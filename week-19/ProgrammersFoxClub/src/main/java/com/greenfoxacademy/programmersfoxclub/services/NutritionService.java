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

    if ((food != null) && (!food.equals(""))) {
      actionHistory.add(new Action(LocalDateTime.now(), "Food has been changed from: " + fox.getFood() + " to: " + food));
      fox.setFood(food);
      if (!nutritionRepository.findAllFood().contains(food.toLowerCase())) {
        ArrayList<String> specialFood = fox.findAllSpecialFood();
        specialFood.add(food);
        fox.setSpecialFood(specialFood);
      }
    }

    if ((drink != null) && (!drink.equals(""))) {
      actionHistory.add(new Action(LocalDateTime.now(), "Drink has been changed from: " + fox.getDrink() + " to: " + drink));
      fox.setDrink(drink);
      if (!nutritionRepository.findAllDrink().contains(drink.toLowerCase())) {
        ArrayList<String> specialDrink = fox.findAllSpecialDrink();
        specialDrink.add(drink);
        fox.setSpecialDrink(specialDrink);
      }
    }
    fox.setActionHistory(actionHistory);
  }

  public ArrayList<String> findAllFood(String name) {
    ArrayList<String> specialFood = foxRepository.findByName(name).findAllSpecialFood();
    ArrayList<String> basicFood = findBasicFood();

    return findAllOption(specialFood, basicFood);
  }

  public ArrayList<String> findAllDrink(String name) {
    ArrayList<String> specialDrink = foxRepository.findByName(name).findAllSpecialDrink();
    ArrayList<String> basicDrink = findBasicDrink();

    return findAllOption(specialDrink, basicDrink);
  }

  public ArrayList<String> findAllOption(ArrayList<String> specialList, ArrayList<String> basicList){
    ArrayList<String> allOption = new ArrayList<>();
    allOption.addAll(basicList);
    for (String element : specialList){
      if (!basicList.contains(element.toLowerCase())){
        allOption.add(element.toLowerCase());
      }
    }
    return allOption;
  }

  public ArrayList<String> findBasicDrink() {
    return nutritionRepository.findAllDrink();
  }

  public ArrayList<String> findBasicFood() {
    return nutritionRepository.findAllFood();
  }
}
