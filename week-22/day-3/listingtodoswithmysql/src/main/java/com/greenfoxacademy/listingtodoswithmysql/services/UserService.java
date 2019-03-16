package com.greenfoxacademy.listingtodoswithmysql.services;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.models.User;
import com.greenfoxacademy.listingtodoswithmysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
  private UserRepository userRepository;
  private TodoService todoService;

  @Autowired
  public UserService(UserRepository userRepository, TodoService todoService){
    this.userRepository = userRepository;
    this.todoService = todoService;
  }

  public void save(User user){
    userRepository.save(user);
  }

  public ArrayList<Todo> findAllTodoByUserId(long userId){
    ArrayList<Todo> todos = todoService.findAllTodo();
    ArrayList<Todo> todosByUserId = new ArrayList<>();
    for (Todo todo : todos){
      if(todo.getUserId() == userId){
        todosByUserId.add(todo);
      }
    }
    return todosByUserId;
  }

  public ArrayList<Todo> findUndoneTodosByUserId(long userId){
    ArrayList<Todo> todos = findAllTodoByUserId(userId);
    ArrayList<Todo> undoneTodos = new ArrayList<>();
    for (Todo todo : todos){
      if(!todo.isDone()){
        undoneTodos.add(todo);
      }
    }
    return undoneTodos;
  }

  public void setUserTodos(long userId){
    findUserById(userId).setTodos(findAllTodoByUserId(userId));
  }

  public User findUserById(long userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    User user = new User();
    if(userOptional.isPresent()) {
      user = userOptional.get();    }
    return user;

  }


  public boolean checkExistUserByName(String name){
    if (name != null) {
      ArrayList<User> users = findAllUser();
      for (User user : users) {
        if (user.getName().equalsIgnoreCase(name)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkExistUserById(long userId){
    return userRepository.existsById(userId);
  }

  public boolean checkCorrectPassword(User user){
    String passwordFromLoginForm = user.getPassword();
    String passwordSavedInRepository = findByName(user.getName()).getPassword();
    return passwordFromLoginForm.equals(passwordSavedInRepository);
  }

//  public void createUser(String name, String password){
//    if (!userRepository.findAll().containsKey(name)) {
//      User newUser = new User(name, password);
//      userRepository.save(newUser);
//    }
//  }

  public User findByName(String name){
    User userInRepository = new User();
    if (name != null){
      ArrayList<User> users = findAllUser();
      for (User user : users){
        if (user.getName().equalsIgnoreCase(name)){
          userInRepository = user;
        }
      }
    }
    return userInRepository;
  }

  public ArrayList<User> findAllUser(){
    ArrayList<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }
}

