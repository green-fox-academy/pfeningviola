package com.greenfoxacademy.dependencies.services;

import org.springframework.stereotype.Service;


public class PurpleColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is purple in color...");
  }
}
