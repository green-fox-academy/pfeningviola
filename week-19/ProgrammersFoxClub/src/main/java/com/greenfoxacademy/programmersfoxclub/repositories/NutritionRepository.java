package com.greenfoxacademy.programmersfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class NutritionRepository {
  private ArrayList<String> possibleDrink;
  private ArrayList<String> possibleFood;

  public NutritionRepository() {
    this.possibleDrink = new ArrayList<>(Arrays.asList("lemonade", "water", "vodka", "beer", "wine", "orange juice"));
    this.possibleFood = new ArrayList<>(Arrays.asList("pizza", "salad", "chicken", "steak", "hamburger", "fish and chips", "sandwich", "soap"));
  }

  public ArrayList<String> findAllDrink() {
    return possibleDrink;
  }

  public void setPossibleDrink(ArrayList<String> possibleDrink) {
    this.possibleDrink = possibleDrink;
  }

  public ArrayList<String> findAllFood() {
    return possibleFood;
  }

  public void setPossibleFood(ArrayList<String> possibleFood) {
    this.possibleFood = possibleFood;
  }
}
