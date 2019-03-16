package com.greenfoxacademy.listingtodoswithmysql.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String name;
  private String password;
  private ArrayList<Todo> todos;

  public User() {
    this.todos = new ArrayList<>();
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList<Todo> getTodos() {
    return todos;
  }

  public void setTodos(ArrayList<Todo> todos) {
    this.todos = todos;
  }
}
