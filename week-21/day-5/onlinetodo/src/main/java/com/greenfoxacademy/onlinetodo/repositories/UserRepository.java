package com.greenfoxacademy.onlinetodo.repositories;

import com.greenfoxacademy.onlinetodo.models.User;

import java.util.HashMap;

public interface UserRepository {
  public HashMap<String, User> findAll();
  public User findByName(String name);
  public void save(User user);
}
