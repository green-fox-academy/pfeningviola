package com.greenfoxacademy.programmersfoxclub.services;

import com.greenfoxacademy.programmersfoxclub.models.Fox;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxHashMapRepository;
import com.greenfoxacademy.programmersfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class NutritionTimerService {

  private FoxRepository foxRepository;

  @Autowired
  public NutritionTimerService(FoxHashMapRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public void decreaseFoodLevel(String name){
    Fox fox = foxRepository.findByName(name);
    Timer timer = new Timer();

    timer.schedule( new TimerTask() {
      public void run() {
        if (fox.getFoodLevel() > 0) {
          fox.setFoodLevel(fox.getFoodLevel() - 1);
        } else {
          timer.cancel();
        }
      }
    }, 60*60*1000, 60*60*1000);
  }
}
