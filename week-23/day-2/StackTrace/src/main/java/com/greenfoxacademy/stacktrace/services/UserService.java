package com.greenfoxacademy.stacktrace.services;

import com.greenfoxacademy.stacktrace.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

  private ArrayList<User> users;

  public UserService() {
    this.users = new ArrayList<>();
  }

  public ArrayList<User> getAll() {
    return users;
  }

  public void save(User user) {
    users.add(user);
  }

  public UserService service() {
    return new UserService();
  }
}
