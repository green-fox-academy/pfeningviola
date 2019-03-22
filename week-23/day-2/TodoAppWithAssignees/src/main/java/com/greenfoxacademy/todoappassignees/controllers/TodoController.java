package com.greenfoxacademy.todoappassignees.controllers;

import com.greenfoxacademy.todoappassignees.models.Todo;
import com.greenfoxacademy.todoappassignees.services.AssigneeService;
import com.greenfoxacademy.todoappassignees.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public TodoController(TodoService todoService, AssigneeService assigneeService){
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @GetMapping({"/", "/list", ""})
  public String list(Model model, @RequestParam(required = false) boolean isActive,
                     @RequestParam(required = false) String title,
                     @RequestParam(required = false) String name,
                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate){
//                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dueDate) {
    ArrayList<Todo> todos;
    if (isActive) {
      todos = todoService.findUndoneTodos();
    } else if (checkIfIsFilledFieldInTheForm(title, name, dueDate)){
//      LocalDate localDate = null;
//      if(dueDate != null && !dueDate.isEmpty()){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        localDate = LocalDate.parse(dueDate, formatter);
//      }
      todos = todoService.findSearchedTodos(title.trim(), name.trim(), dueDate);
    } else {
      todos = todoService.findAllTodo();
    }
    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/add")
  public String renderAddNewTodoForm(Model model){
    model.addAttribute("assignees", assigneeService.findAll());
    return "addtodo";
  }

  @PostMapping("/add")
  public String addNewTodo(@ModelAttribute Todo newTodo){
    if(newTodo.getDueDate() != null) {
      newTodo.setDueDate(newTodo.getDueDate().plusDays(1));
    }
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
    findTodoAndAddToModel(id, model);
    model.addAttribute("assignees", assigneeService.findAll());
    return "edittodo";
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@ModelAttribute Todo todo, @PathVariable long id){
    if(todo.getDueDate() != null) {
      todo.setDueDate(todo.getDueDate().plusDays(1));
    }
    todoService.save(todo);
    return "redirect:/todo/";
  }

  @GetMapping("/{id}/details")
  public String renderTodoDetailsPage(@PathVariable long id, Model model){
    findTodoAndAddToModel(id, model);
    return "tododetails";
  }

  @PostMapping("/{id}/complete")
  public String completeTodo(@PathVariable long id){
    todoService.complete(id);
    return "redirect:/todo/";
  }

  private void findTodoAndAddToModel(long id, Model model){
    if (!todoService.checkIdExists((id))){
      model.addAttribute("noTodo", "There is no todo with given id.");
    } else {
      Todo todo = todoService.findById(id);
      model.addAttribute("todo", todo);
    }
  }

  private boolean checkIfIsFilledFieldInTheForm(String title, String name, LocalDate dueDate){
    return ((title != null) && (!title.isEmpty()) || ((name != null) && (!name.isEmpty())) || (dueDate != null));
  }
}
