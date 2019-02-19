package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private ArrayList<String> knownTricks;

  public Fox(String name) {
    this.name = name;
    this.food = "steak";
    this.drink = "orange juice";
    this.knownTricks = new ArrayList<>();
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

  public ArrayList<String> getKnownTricks() {
    return knownTricks;
  }

  public void setKnownTricks(ArrayList<String> knownTricks) {
    this.knownTricks = knownTricks;
  }
}
