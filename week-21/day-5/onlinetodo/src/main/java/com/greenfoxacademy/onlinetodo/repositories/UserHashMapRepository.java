package com.greenfoxacademy.onlinetodo.repositories;

import com.greenfoxacademy.onlinetodo.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserHashMapRepository implements UserRepository {
  private HashMap<String, User> users;

  public UserHashMapRepository(){
    this.users = new HashMap<>();
  }

  @Override
  public HashMap<String, User> findAll() {
    return users;
  }

  @Override
  public User findByName(String name) {
    return users.get(name);
  }

  @Override
  public void save(User user) {
    if (user == null){
      throw new IllegalArgumentException("The user doesn't exist.");
    }
    users.put(user.getName(), user);
  }
}
