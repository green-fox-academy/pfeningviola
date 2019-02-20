package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Action;
import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class TrickService {

  private FoxHashMapRepository foxRepository;
  private TrickRepository trickRepository;

  @Autowired
  public TrickService(FoxHashMapRepository foxRepository, TrickRepository trickRepository){
    this.foxRepository = foxRepository;
    this.trickRepository = trickRepository;
  }

  public ArrayList<String> findTricksToLearn(String name){
    ArrayList<String> knownTricks = foxRepository.findByName(name).findAllKnownTricks();
    ArrayList<String> allTricks = trickRepository.findAllTrick();
    ArrayList<String> tricksToLearn = new ArrayList<>();

    for (String trick : allTricks){
      if (!knownTricks.contains(trick)){
        tricksToLearn.add(trick);
      }
    }
    return tricksToLearn;
  }

  public void learnTrick(String name, String trick){
    Fox fox = foxRepository.findByName(name);
    ArrayList<String> knownTricks = fox.findAllKnownTricks();
    ArrayList<Action> actionHistory = fox.findAllActionHistory();
    knownTricks.add(trick);
    fox.setKnownTricks(knownTricks);
    actionHistory.add(new Action(LocalDateTime.now(), "Learned to: " + trick));
    fox.setActionHistory(actionHistory);
  }
}
