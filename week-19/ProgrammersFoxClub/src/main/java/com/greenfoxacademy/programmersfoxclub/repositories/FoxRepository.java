package com.greenfoxacademy.programmersfoxclub.repositories;

import com.greenfoxacademy.programmersfoxclub.models.Fox;

import java.util.HashMap;

public interface FoxRepository {
  public HashMap<String, Fox> findAll();
  public Fox findByName(String name);
  public void save(Fox fox);
}
