package com.greenfoxacademy.todoappassignees.services;

import com.greenfoxacademy.todoappassignees.models.Assignee;
import com.greenfoxacademy.todoappassignees.repositories.AssigneeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;

  public AssigneeService(AssigneeRepository assigneeRepository){
    this.assigneeRepository = assigneeRepository;
  }

  public ArrayList<Assignee> findAll(){
    ArrayList<Assignee> assignees = new ArrayList<>();
    assigneeRepository.findAll().forEach(assignees::add);
    return assignees;
  }

  public void save(Assignee assignee){
    assigneeRepository.save(assignee);
  }

  public void delete(long id){
    assigneeRepository.deleteById(id);
  }

  public Assignee findAssigneeById(long id){
    Optional<Assignee> assigneeInRepository = assigneeRepository.findById(id);
    Assignee assignee = new Assignee();
    if(assigneeInRepository.isPresent()){
      assignee = assigneeInRepository.get();
    }
    return assignee;
  }

  public boolean checkIdExists(long id){
    return assigneeRepository.existsById(id);
  }
}
