package com.greenfoxacademy.todoappassignees.repositories;

import com.greenfoxacademy.todoappassignees.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  ArrayList<Todo> findTodosByTitleContains(String title);
}
