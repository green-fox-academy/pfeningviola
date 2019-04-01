package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.Doubling;
import com.greenfoxacademy.rest.models.Error;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

  @GetMapping("/doubling")
  public Object renderDoublingPage(@RequestParam(name = "input", required = false) Integer received) {
    if (received == null) {
      return new Error();
    } else {
      Doubling result = new Doubling(received);
      return result;
    }
  }
}
