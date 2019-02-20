package com.greenfoxacademy.programmersfoxclub.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Action {

  private String actionTime;
  private String actionDescription;

  public Action(LocalDateTime actionTime, String actionDescription){
    this.actionTime = actionTimeToString(actionTime);
    this.actionDescription = actionDescription;
  }

  public String actionTimeToString(LocalDateTime actionTime){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MMMM dd. HH:mm:ss");
    String formatActionTime = actionTime.format(formatter);
    return formatActionTime;
  }

  public String getActionTime() {
    return actionTime;
  }

  public void setActionTime(String actionTime) {
    this.actionTime = actionTime;
  }

  public String getActionDescription() {
    return actionDescription;
  }

  public void setActionDescription(String actionDescription) {
    this.actionDescription = actionDescription;
  }
}
