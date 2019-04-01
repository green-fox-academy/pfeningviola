package com.greenfoxacademy.rest.models;

public class Error {
  private String error;

  public Error(){
    this.error = "Please provide an input!";
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
