package com.greenfoxacademy.listingtodosh2;

import com.greenfoxacademy.listingtodosh2.models.Todo;
import com.greenfoxacademy.listingtodosh2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Listingtodosh2Application implements CommandLineRunner {

  @Autowired
  TodoRepository todoRepository;

  public static void main(String[] args) {
    SpringApplication.run(Listingtodosh2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("Buy milk"));
    todoRepository.save(new Todo("Walk the dog"));
    todoRepository.save(new Todo("Feed the dog"));
    todoRepository.save(new Todo("Paint an image"));
  }
}
