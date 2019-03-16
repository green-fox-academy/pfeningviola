package com.greenfoxacademy.listingtodoswithmysql.controllers;

import com.greenfoxacademy.listingtodoswithmysql.models.Todo;
import com.greenfoxacademy.listingtodoswithmysql.models.User;
import com.greenfoxacademy.listingtodoswithmysql.services.TodoService;
import com.greenfoxacademy.listingtodoswithmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/{userId}/todo")
public class TodoController {

  private TodoService todoService;
  private UserService userService;

  @Autowired
  public TodoController(TodoService todoService, UserService userService){
    this.todoService = todoService;
    this.userService = userService;
  }

  @GetMapping({"/", "/list", ""})
  public String list(Model model, @PathVariable long userId, @RequestParam(required = false) boolean isActive) {
    if (userService.checkExistUserById(userId)) {
      ArrayList<Todo> todos;
      User user = userService.findUserById(userId);
      model.addAttribute("user", user);
      if (isActive) {
        todos = userService.findUndoneTodosByUserId(userId);
      } else {
        todos = userService.findAllTodoByUserId(userId);
      }
      model.addAttribute("todos", todos);
      return "todolist";
    } else {
      return "error";
    }
  }

//  @GetMapping("/list")
//  public String list2(){
//    return "redirect:/todo/";
//  }

  @GetMapping("/add")
  public String renderAddNewTodoForm(@PathVariable long userId, Model model){
    if (userService.checkExistUserById(userId)) {
      model.addAttribute("userId", userId);
      return "addtodo";
    } else {
      return "error";
    }
  }

  @PostMapping("/add")
  public String addNewTodo(@PathVariable long userId, @ModelAttribute Todo newTodo){
    todoService.save(newTodo);
    return "redirect:/" + userId + "/todo/";
  }

  @PostMapping("/{id}/delete")
  public String deleteTodo(@PathVariable long userId, @PathVariable long id){
    todoService.delete(id);
    return "redirect:/" + userId + "/todo/";
  }

  @GetMapping("/{id}/edit")
  public String renderEditTodoPage(@PathVariable long userId, @PathVariable long id, Model model){
    if (userService.checkExistUserById(userId)) {
      findTodoAndAddToModel(id, userId, model);
      return "edittodo";
    } else {
      return "error";
    }
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@PathVariable long userId, @ModelAttribute Todo todo, @PathVariable long id){
    todoService.save(todo);
    return "redirect:/" + userId + "/todo/";
  }

  @GetMapping("/{id}/details")
  public String renderTodoDetailsPage(@PathVariable long userId, @PathVariable long id, Model model){
    if (userService.checkExistUserById(userId)) {
      findTodoAndAddToModel(id, userId, model);
      return "tododetails";
    } else {
      return "error";
    }
  }

  @PostMapping("/{id}/complete")
  public String completeTodo(@PathVariable long userId, @PathVariable long id){
    todoService.complete(id);
    return "redirect:/" + userId + "/todo/";
  }

  private void findTodoAndAddToModel(long id, long userId, Model model){
    model.addAttribute("userId", userId);
    if (!todoService.checkIdExists((id))){
      model.addAttribute("noTodo", "There is no todo with given id.");
    } else {
      Todo todo = todoService.findById(id);
      model.addAttribute("todo", todo);
    }
  }
}
