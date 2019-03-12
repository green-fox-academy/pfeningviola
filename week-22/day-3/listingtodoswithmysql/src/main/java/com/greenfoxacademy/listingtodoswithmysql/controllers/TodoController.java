package com.greenfoxacademy.listingtodoswithmysql.controllers;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository){
    this.todoRepository = todoRepository;
  }

  @GetMapping("/list")
  public String list(Model model) {
    ArrayList<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/")
  public String list2(){
    return "redirect:/todo/list";
  }
}
