package com.greenfoxacademy.redditproject.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Post implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String url;
  private LocalDateTime createdAt;
  private int score;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post(){
    this.createdAt = LocalDateTime.now();
    this.score = 0;
  }

  public String timeFromCreation() {
    Duration duration = Duration.between(createdAt, LocalDateTime.now());
    long numberOfHours = duration.getSeconds() / 60 / 60;
    if (duration.getSeconds() < 60) {
      return "just a few seconds";
    } else if ((duration.getSeconds() / 60) == 1) {
      return "1 minute";
    } else if (((duration.getSeconds() / 60) < 60) && ((duration.getSeconds() / 60) > 1)) {
      return (duration.getSeconds() / 60) + " minutes";
    } else if (numberOfHours == 1) {
      return "1 hour";
    } else if ((numberOfHours > 1) && (numberOfHours < 24)){
      return numberOfHours + " hours";
    } else if ((numberOfHours >= 24) && (numberOfHours < 48)){
      return "1 day";
    } else if ((numberOfHours >= 48) && (numberOfHours < 720)) {
      return numberOfHours / 24 + " days";
    } else if ((numberOfHours >= 720) && (numberOfHours < 1440)){
      return "1 month";
    } else {
      return (numberOfHours / 24 / 30) + " months";
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
