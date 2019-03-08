package com.greenfoxacademy.onlinetodo.models;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

public class Todo {
  private String description;
  private int id;
  private static int idCounter = 0;
  private LocalDateTime createdAt;
  private LocalDateTime completedAt;

  public Todo(String description) {
    this.description = description;
    idCounter++;
    this.id = idCounter;
    this.createdAt = LocalDateTime.now(Clock.systemUTC());
    this.completedAt = null;
  }

  public Duration completionTime() {
    return Duration.between(createdAt, completedAt);
  }

  public String completionTimeToString() {
    Duration time = completionTime();
    long days =  time.getSeconds() / (3600 * 24);
    long hours = (time.getSeconds() % (3600 * 24)) / 3600;
    long minutes = ((time.getSeconds() % (3600 * 24)) / 60) % 60;

    return String.format("%d days, %d hours, %d minutes",
        days, hours, minutes);
  }

  public boolean isCompleted() {
    boolean completedTask = false;
    if (completedAt != null && completedAt.isBefore(LocalDateTime.now(Clock.systemUTC()))){
      completedTask = true;
    }
    return completedTask;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public static int getIdCounter() {
    return idCounter;
  }

  public static void setIdCounter(int idCounter) {
    Todo.idCounter = idCounter;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return (isCompleted() ? "[x] " : "[ ] ") + description + " (id: "  + id + ")" + (isCompleted() ? " completed in " + completionTimeToString() : "");
  }
}
