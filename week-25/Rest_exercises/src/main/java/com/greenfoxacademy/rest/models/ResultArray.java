package com.greenfoxacademy.rest.models;

import java.util.List;

public class ResultArray {
  private List<Integer> result;

  public ResultArray(List<Integer> result) {
    this.result = result;
  }

  public List<Integer> getResult() {
    return result;
  }

  public void setResult(List<Integer> result) {
    this.result = result;
  }
}
