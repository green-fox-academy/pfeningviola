package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.Doubling;
import com.greenfoxacademy.rest.models.Error;
import com.greenfoxacademy.rest.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

  @GetMapping("/doubling")
  public Object renderDoublingPage(@RequestParam(name = "input", required = false) Integer received) {
    if (received == null) {
      return new Error("an input");
    } else {
      Doubling result = new Doubling(received);
      return result;
    }
  }

  @GetMapping("/greeter")
  public Object greet(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "title", required = false) String title){
    if ((name == null) && (title == null)){
      return new Error("a name and a title");
    } else if (name == null) {
      return new Error("a name");
    } else if (title == null){
      return new Error("a title");
    } else {
      return new Greeting(name, title);
    }
  }
}
