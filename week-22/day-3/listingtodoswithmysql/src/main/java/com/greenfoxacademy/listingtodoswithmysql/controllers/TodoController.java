package com.greenfoxacademy.listingtodoswithmysql.controllers;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.repositories.TodoRepository;
import com.greenfoxacademy.listingtodoswithmysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService){
    this.todoService = todoService;
  }

  @GetMapping("/")
  public String list(Model model, @RequestParam(required = false) boolean isActive) {
    ArrayList<Todo> todos;
    if (isActive) {
      todos = todoService.findUndoneTodos();
    } else {
      todos = todoService.findAllTodo();
    }
    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/list")
  public String list2(){
    return "redirect:/todo/";
  }

  @GetMapping("/add")
  public String renderAddNewTodoForm(){
    return "addtodo";
  }

  @PostMapping("/add")
  public String addNewTodo(@ModelAttribute Todo newTodo){
    todoService.save(newTodo);
    return "redirect:/todo/";
  }

  @PostMapping("/{id}/delete")
  public String deleteTodo(@PathVariable long id){
    todoService.delete(id);
    return "redirect:/todo/";
  }

  @GetMapping("/{id}/edit")
  public String renderEditTodoPage(@PathVariable long id, Model model){
    Todo todo = todoService.findById(id);
    model.addAttribute("todo", todo);
    return "edittodo";
  }
}
