package com.greenfoxacademy.programmersfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class TrickRepository {

  private ArrayList<String> trickList;

  public TrickRepository(){
    this.trickList = new ArrayList<>(Arrays.asList("HTML & CSS", "Java", "SQL", "JavaScript", "C++", "Angular", "Spring"));
  }

  public ArrayList<String> findAllTrick(){
    return trickList;
  }
}
