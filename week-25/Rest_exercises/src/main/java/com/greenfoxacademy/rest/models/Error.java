package com.greenfoxacademy.rest.models;

public class Error {
  private String error;

  public Error(String error){
    this.error = "Please provide " + error + "!";
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
