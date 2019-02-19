package com.greenfoxacademy.programmersfoxclub.models;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleDrink {
  private ArrayList<String> possibleDrink;

  public PossibleDrink() {
    this.possibleDrink = new ArrayList<>(Arrays.asList("lemonade", "water", "vodka", "beer", "wine", "orange juice"));
  }

  public ArrayList<String> getPossibleDrink() {
    return possibleDrink;
  }

  public void setPossibleDrink(ArrayList<String> possibleDrink) {
    this.possibleDrink = possibleDrink;
  }
}
