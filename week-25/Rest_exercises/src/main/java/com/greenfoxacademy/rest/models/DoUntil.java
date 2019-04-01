package com.greenfoxacademy.rest.models;

public class DoUntil {

  private int result;

  public DoUntil(String action, Integer until){
    if(action.equals("sum")) {
      this.result = sumUntil(until);
    }
    if(action.equals("factor")){
      this.result = factorUntil(until);
    }
  }

  public int sumUntil(int until){
    int result = 0;
    for (int i = 0; i <= until; i++){
      result = result + i;
    }
    return result;
  }

  public int factorUntil(int until){
    int result = 1;
    for (int i = 1; i <= until; i++){
      result = result * i;
    }
    return result;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
