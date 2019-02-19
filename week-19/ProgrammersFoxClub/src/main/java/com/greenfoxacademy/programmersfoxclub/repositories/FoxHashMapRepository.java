package com.greenfoxacademy.programmersfoxclub.repositories;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FoxHashMapRepository implements FoxRepository {
  private HashMap<String, Fox> foxList;

  public FoxHashMapRepository() {
    this.foxList = new HashMap<>();
  }

  @Override
  public void save(Fox fox){
    foxList.put(fox.getName(), fox);
  }

  @Override
  public HashMap<String, Fox> findAll() {
    return foxList;
  }

  @Override
  public Fox findByName(String name){
    return foxList.get(name);
  }
  
  public void setFoxList(HashMap<String, Fox> foxList) {
    this.foxList = foxList;
  }
}
