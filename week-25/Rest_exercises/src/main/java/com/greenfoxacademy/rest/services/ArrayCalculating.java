package com.greenfoxacademy.rest.services;

import com.greenfoxacademy.rest.models.Array;
import com.greenfoxacademy.rest.models.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayCalculating {

  public int summarize(List<Integer> input){
    int sum = 0;
    for (int i = 0; i < input.size(); i++){
      sum = sum + input.get(i);
    }
    return sum;
  }

  public int multiply(List<Integer> input){
    int result = 1;
    for (int i = 0; i < input.size(); i++){
      result = result * input.get(i);
    }
    return result;
  }

  public ArrayList<Integer> doubleTheNumbers(List<Integer> input){
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < input.size(); i++){
      result.add(input.get(i) * 2);
    }
    return result;
  }
}
