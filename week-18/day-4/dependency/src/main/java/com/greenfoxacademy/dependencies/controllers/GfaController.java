package com.greenfoxacademy.dependencies.controllers;

import com.greenfoxacademy.dependencies.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GfaController {
  private StudentService studentService;

  @Autowired
  public GfaController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/gfa")
  public String renderMainGFAPage(Model model){
    model.addAttribute("studentsnumber", studentService.count());
    return "gfa";
  }

  @GetMapping("gfa/list")
  public String renderAllStudents(Model model){
    model.addAttribute("students", studentService.findAll());
    model.addAttribute("studentsnumber", studentService.count());
    return "gfa-students";
  }

  @GetMapping("/gfa/add")
  public String renderNewStudent(Model model){
    model.addAttribute("studentsnumber", studentService.count());
    return "gfa-add-student";
  }

  @GetMapping("/gfa/save")
  public String renderAddNewStudent(@RequestParam String name) {
    studentService.save(name);
    return "redirect:/gfa/list";
  }
}
