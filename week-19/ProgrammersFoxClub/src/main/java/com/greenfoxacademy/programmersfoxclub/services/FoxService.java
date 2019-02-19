package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxHashMapRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public Fox login(String name){
    if (!foxRepository.findAll().containsKey(name)) {
      Fox newFox = new Fox(name);
      foxRepository.save(newFox);
    }
    Fox fox = foxRepository.findByName(name);
    return fox;
  }
}
