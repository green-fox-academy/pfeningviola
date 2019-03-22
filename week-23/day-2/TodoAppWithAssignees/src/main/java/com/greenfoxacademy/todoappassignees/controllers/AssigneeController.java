package com.greenfoxacademy.todoappassignees.controllers;

import com.greenfoxacademy.todoappassignees.models.Assignee;
import com.greenfoxacademy.todoappassignees.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

  private AssigneeService assigneeService;

  @Autowired
  public AssigneeController(AssigneeService assigneeService){
    this.assigneeService = assigneeService;
  }

  @GetMapping({"/", "/list", ""})
  public String renderAssigneeList(Model model){
    ArrayList<Assignee> assignees = assigneeService.findAll();
    model.addAttribute("assignees", assignees);
    return "assigneelist";
  }

  @PostMapping("/add")
  public String addNewTodo(@ModelAttribute Assignee newAssignee){
    assigneeService.save(newAssignee);
    return "redirect:/assignee/";
  }

  @PostMapping("/{id}/delete")
  public String deleteAssignee(@PathVariable long id){
    assigneeService.delete(id);
    return "redirect:/assignee/";
  }

  @GetMapping("/{id}/edit")
  public String renderEditTodoPage(@PathVariable long id, Model model){
    findAssigneeAndAddToModel(id, model);
    return "editassignee";
  }

  @PostMapping("/{id}/edit")
  public String editAssignee(@ModelAttribute Assignee assignee, @PathVariable long id){
    assigneeService.save(assignee);
    return "redirect:/assignee/";
  }

  @GetMapping("/{id}/details")
  public String renderAssigneeDetailsPage(@PathVariable long id, Model model){
    findAssigneeAndAddToModel(id, model);
    return "assigneedetails";
  }

  private void findAssigneeAndAddToModel(long id, Model model){
    if (!assigneeService.checkIdExists((id))){
      model.addAttribute("noAssignee", "There is no assignee with given id.");
    } else {
      Assignee assignee = assigneeService.findAssigneeById(id);
      model.addAttribute("assignee", assignee);
    }
  }


}
