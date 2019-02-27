package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class TrickTimerService {

  private FoxRepository foxRepository;

  @Autowired
  public TrickTimerService(FoxHashMapRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public void learnTrickProcess(String name){
    Fox fox = foxRepository.findByName(name);
    Timer timer = new Timer();
    fox.setRemainingLearningTime(30);
    fox.setLearningProcessState(0);

    timer.schedule( new TimerTask() {
      public void run() {
        if (fox.getRemainingLearningTime() > 0) {
          fox.setRemainingLearningTime(fox.getRemainingLearningTime() - 5);
          fox.setLearningProcessState(fox.getLearningProcessState() + (100 / 5));

        } else {
          timer.cancel();
        }
      }
    }, 5*1000, 5*1000);
  }
}
