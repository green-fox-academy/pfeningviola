package com.greenfoxacademy.listingtodoswithmysql.services;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository){
    this.todoRepository = todoRepository;
  }

  public ArrayList<Todo> findAllTodo(){
    ArrayList<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    return todos;
  }

  public ArrayList<Todo> findUndoneTodos(){
    ArrayList<Todo> todos = findAllTodo();
    ArrayList<Todo> undoneTodos = new ArrayList<>();
    for (Todo todo : todos){
      if(!todo.isDone()){
        undoneTodos.add(todo);
      }
    }
    return undoneTodos;
  }

  public void save(Todo todo){
    todoRepository.save(todo);
  }

  public void delete(long id){
    todoRepository.deleteById(id);
  }

  public void complete(long id) {
    Todo todo = findById(id);
    if(todo.isDone()){
      todo.setDone(false);
      todo.setCompletedAt(null);
    } else {
      todo.setDone(true);
      todo.setCompletedAt(LocalDateTime.now(Clock.systemUTC()));
    }
    save(todo);
  }

  public Todo findById(long id){
    Optional<Todo> todoInRepository = todoRepository.findById(id);
    Todo todo = new Todo();
    if(todoInRepository.isPresent()){
      todo = todoInRepository.get();
    }
    return todo;
  }

  public boolean checkIdExists(long id){
    return todoRepository.existsById(id);
  }
}
