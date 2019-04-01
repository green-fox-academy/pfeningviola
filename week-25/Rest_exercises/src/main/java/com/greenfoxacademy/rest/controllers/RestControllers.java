package com.greenfoxacademy.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.greenfoxacademy.rest.models.*;
import com.greenfoxacademy.rest.models.Error;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllers {

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

  @GetMapping("/appenda/{appendable}")
  public Object appendA(@PathVariable String appendable){
    if (appendable == null){
      return "redirect:/404";
    }
    return new AppendA(appendable);
  }

  @PostMapping("/dountil/{action}")
  public Object doUntil(@PathVariable String action, @RequestBody Until jsonUntil ){

    if (jsonUntil == null){
      return new Error("a number");
    }
    return new DoUntil(action, jsonUntil.getUntil());
  }
}
