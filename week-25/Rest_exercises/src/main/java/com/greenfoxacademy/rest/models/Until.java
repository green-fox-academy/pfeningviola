package com.greenfoxacademy.rest.models;

public class Until {
  private int until;

  public Until(){}

  public int getUntil() {
    return until;
  }

  public void setUntil(int until) {
    this.until = until;
  }

  @Override
  public String toString() {
    return "Until{" +
        "until=" + until +
        '}';
  }
}
