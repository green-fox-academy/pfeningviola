package com.greenfoxacademy.todoappassignees.services;

import com.greenfoxacademy.todoappassignees.models.Assignee;
import com.greenfoxacademy.todoappassignees.models.Todo;
import com.greenfoxacademy.todoappassignees.repositories.TodoRepository;
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

  public ArrayList<Todo> findAllTodoWithSearchedTitle(String title){
    ArrayList<Todo> todos = findAllTodo();
    ArrayList<Todo> searchedTodos = new ArrayList<>();
    for (Todo todo : todos){
      if(todo.getTitle().toLowerCase().contains(title.toLowerCase())){
        searchedTodos.add(todo);
      }
    }
    return searchedTodos;
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

  public ArrayList<Todo> findSearchedTodos(String title, String name){
    ArrayList<Todo> searchedTodos = new ArrayList<>();
    if (((title != null) && (!title.isEmpty()) && ((name == null) || (name.isEmpty())))){
      searchedTodos = findTodosByTitleContains(title);
    } else if (((title == null) || (title.isEmpty()) && ((name != null) && (!name.isEmpty())))) {
      searchedTodos = findTodosByAssigneeNameContains(name);
    } else if (((title != null) && (!title.isEmpty()) && ((name != null) && (!name.isEmpty())))){
      searchedTodos =findTodosByTitleContainsAndAssigneeNameContains(title, name);
    }
    return searchedTodos;
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

  public ArrayList<Todo> findTodosByTitleContains(String title){
    return todoRepository.findTodosByTitleContains(title);
  }

  public ArrayList<Todo> findTodosByAssigneeNameContains(String name){
    return todoRepository.findTodosByAssigneeNameContains(name);
  }

  public ArrayList<Todo> findTodosByTitleContainsAndAssigneeNameContains(String title, String name){
    return todoRepository.findTodosByTitleContainsAndAssigneeNameContains(title, name);
  }
}
