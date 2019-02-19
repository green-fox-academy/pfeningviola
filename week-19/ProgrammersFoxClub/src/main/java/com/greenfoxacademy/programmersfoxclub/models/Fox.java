package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;

public class Fox {
  private String name;
  private String lastFood;
  private String lastDrink;
  private ArrayList<String> knownTricks;

  public Fox(String name) {
    this.name = name;
    this.lastFood = "steak";
    this.lastDrink = "orange juice";
    this.knownTricks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastFood() {
    return lastFood;
  }

  public void setLastFood(String lastFood) {
    this.lastFood = lastFood;
  }

  public String getLastDrink() {
    return lastDrink;
  }

  public void setLastDrink(String lastDrink) {
    this.lastDrink = lastDrink;
  }

  public ArrayList<String> getKnownTricks() {
    return knownTricks;
  }

  public void setKnownTricks(ArrayList<String> knownTricks) {
    this.knownTricks = knownTricks;
  }
}
