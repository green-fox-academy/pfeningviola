package com.greenfoxacademy.rest.models;

public class SithError {
  private String error;

  public SithError(){
    this.error = "Feed me some text you have to, padawan young you are. Hmmm.";
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
