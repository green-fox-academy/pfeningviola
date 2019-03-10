package com.greenfoxacademy.onlinetodo.models;

import java.util.ArrayList;

public class User {
  private String name;
  private String password;
  private int userID;
  private static int userIDCounter = 0;
  private ArrayList<Todo> todos;

  public User(String name, String password){
    this.name = name;
    this.password = password;
    userIDCounter ++;
    this.userID = userIDCounter;
    this.todos = new ArrayList<>();
  }

  public ArrayList<Todo> findAllTodo(){
    return todos;
  }

  public Todo findByIndex(int index){
    return todos.get(index);
  }

  public void save(Todo todo){
    todos.add(todo);
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

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public static int getUserIDCounter() {
    return userIDCounter;
  }

  public static void setUserIDCounter(int userIDCounter) {
    User.userIDCounter = userIDCounter;
  }
}
