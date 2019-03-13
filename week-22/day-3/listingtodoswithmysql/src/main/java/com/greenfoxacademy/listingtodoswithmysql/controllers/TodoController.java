package com.greenfoxacademy.listingtodoswithmysql.controllers;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.repositories.TodoRepository;
import com.greenfoxacademy.listingtodoswithmysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public String list(Model model) {
    ArrayList<Todo> todos = todoService.findAllTodo();
    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/list")
  public String list2(){
    return "redirect:/todo/";
  }
}
