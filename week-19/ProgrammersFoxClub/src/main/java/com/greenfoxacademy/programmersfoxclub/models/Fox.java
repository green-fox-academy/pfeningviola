package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private ArrayList<String> knownTricks;
  private ArrayList<Action> actionHistory;
  private String filename;

  public Fox(String name, String filename) {
    this.name = name;
    this.filename = filename;
    this.food = "steak";
    this.drink = "orange juice";
    this.knownTricks = new ArrayList<>();
    this.actionHistory = new ArrayList<>();
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

  public void setActionHistory(ArrayList<Action> actionHistory) {
    this.actionHistory = actionHistory;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }
}
