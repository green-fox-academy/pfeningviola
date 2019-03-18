package com.greenfoxacademy.todoappassignees.services;

import com.greenfoxacademy.todoappassignees.repositories.AssigneeRepository;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;

  public AssigneeService(AssigneeRepository assigneeRepository){
    this.assigneeRepository = assigneeRepository;
  }
}
