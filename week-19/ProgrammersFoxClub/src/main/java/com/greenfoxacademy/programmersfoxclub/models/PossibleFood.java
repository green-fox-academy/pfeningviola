package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleFood {

  private ArrayList<String> possibleFood;

  public PossibleFood() {
    possibleFood = new ArrayList<>(Arrays.asList("pizza", "salad", "chicken", "steak", "hamburger", "fish and chips", "sandwich", "soap"));
  }

  public ArrayList<String> getPossibleFood() {
    return possibleFood;
  }

  public void setPossibleFood(ArrayList<String> possibleFood) {
    this.possibleFood = possibleFood;
  }
}
