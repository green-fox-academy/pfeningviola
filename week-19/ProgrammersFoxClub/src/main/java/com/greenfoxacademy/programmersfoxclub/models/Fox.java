package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private ArrayList<String> knownTricks;
  private ArrayList<Action> actionHistory;
  private String filename;
  private ArrayList<String> specialFood;
  private ArrayList<String> specialDrink;
  private int foodLevel;
  private int maxFoodLevel;
  private boolean learningState;

  public Fox(String name, String filename) {
    this.name = name;
    this.filename = filename;
    this.food = "steak";
    this.drink = "orange juice";
    this.knownTricks = new ArrayList<>();
    this.actionHistory = new ArrayList<>();
    this.specialFood = new ArrayList<>();
    this.specialDrink = new ArrayList<>();
    this.foodLevel = 10;
    this.maxFoodLevel = 20;
    this.learningState = false;
  }

  public boolean isAlive(){
    return (foodLevel > 0);
  }

  public boolean isHungry(){
    return ((foodLevel > 0) && (foodLevel <= 5));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public ArrayList<String> findAllKnownTricks() {
    return knownTricks;
  }

  public void setKnownTricks(ArrayList<String> knownTricks) {
    this.knownTricks = knownTricks;
  }

  public ArrayList<Action> findAllActionHistory() {
    return actionHistory;
  }

  public ArrayList<Action> findLast5Action(){
    if (actionHistory.size() <= 5){
      ArrayList<Action> reversedList = actionHistory;
      Collections.reverse(reversedList);
      return reversedList;
    } else {
      ArrayList<Action> last5Action = new ArrayList<>();
      for (int i = actionHistory.size() - 5; i < actionHistory.size(); i++) {
        last5Action.add(actionHistory.get(i));
      }
      Collections.reverse(last5Action);
      return last5Action;
    }
  }

  public void setActionHistory(ArrayList<Action> actionHistory) {
    this.actionHistory = actionHistory;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public ArrayList<String> findAllSpecialFood() {
    return specialFood;
  }

  public void setSpecialFood(ArrayList<String> specialFood) {
    this.specialFood = specialFood;
  }

  public ArrayList<String> findAllSpecialDrink() {
    return specialDrink;
  }

  public void setSpecialDrink(ArrayList<String> specialDrink) {
    this.specialDrink = specialDrink;
  }

  public int getFoodLevel() {
    return foodLevel;
  }

  public void setFoodLevel(int foodLevel) {
    if (foodLevel > this.maxFoodLevel) {
      this.foodLevel = this.maxFoodLevel;
    } else {
      this.foodLevel = foodLevel;
    }
  }

  public int getMaxFoodLevel() {
    return maxFoodLevel;
  }

  public void setMaxFoodLevel(int maxFoodLevel) {
    this.maxFoodLevel = maxFoodLevel;
  }

  public boolean isLearningState() {
    return learningState;
  }

  public void setLearningState(boolean learningState) {
    this.learningState = learningState;
  }
}
