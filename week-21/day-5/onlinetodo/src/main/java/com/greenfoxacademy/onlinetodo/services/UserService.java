package com.greenfoxacademy.onlinetodo.services;

import com.greenfoxacademy.onlinetodo.models.User;
import com.greenfoxacademy.onlinetodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public boolean checkExistUser(User user){
    return userRepository.findAll().containsKey(user.getName());
  }

  public boolean checkCorrectPassword(User user){
    String passwordFromLoginForm = user.getPassword();
    String passwordSavedInRepository = userRepository.findByName(user.getName()).getPassword();
    return passwordFromLoginForm.equals(passwordSavedInRepository);
  }

  public void createUser(String name, String password){
    if (!userRepository.findAll().containsKey(name)) {
      User newUser = new User(name, password);
      userRepository.save(newUser);
    }
  }

  public User findByName(String name){
    return userRepository.findByName(name);
  }

  public HashMap<String, User> findAll(){
    return userRepository.findAll();
  }
}
