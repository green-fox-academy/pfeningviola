package com.greenfoxacademy.bankofsimba.models;

public class BankAccount {
  public static final String CURRENCY = "Zebra";
  private String name;
  private String animalType;
  private int balance;
  private boolean king;
  private boolean goodCharacter;

  public BankAccount(String name, int balance, String animalType, boolean king, boolean good) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = king;
    this.goodCharacter = good;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public boolean isKing() {
    return king;
  }

  public void setKing(boolean king) {
    this.king = king;
  }

  public boolean isGoodCharacter() {
    return goodCharacter;
  }

  public void setGoodCharacter(boolean goodCharacter) {
    this.goodCharacter = goodCharacter;
  }

  public static String getCURRENCY() {
    return CURRENCY;
  }
}
