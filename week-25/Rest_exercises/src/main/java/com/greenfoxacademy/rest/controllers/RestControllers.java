package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.*;
import com.greenfoxacademy.rest.models.Error;
import com.greenfoxacademy.rest.services.ArrayCalculating;
import com.greenfoxacademy.rest.services.LogService;
import com.greenfoxacademy.rest.services.SithReverserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllers {
  private ArrayCalculating arrayCalculating;
  private LogService logService;
  private SithReverserService sithReverserService;

  @Autowired
  public RestControllers(ArrayCalculating arrayCalculating, LogService logService, SithReverserService sithReverserService){
    this.arrayCalculating = arrayCalculating;
    this.logService = logService;
    this.sithReverserService = sithReverserService;
  }

  @GetMapping("/doubling")
  public Object renderDoublingPage(@RequestParam(name = "input", required = false) Integer received) {
    logService.save(new Log("/doubling", "input=" + received));
    if (received == null) {
      return new Error("an input");
    } else {
      Doubling result = new Doubling(received);
      return result;
    }
  }

  @GetMapping("/greeter")
  public Object greet(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "title", required = false) String title){
    logService.save(new Log("/greeter", "name=" + name + "&title=" + title));
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
    logService.save(new Log("/appenda/{appendable}", "appendable=" + appendable));
    if (appendable == null){
      return "redirect:/404";
    }
    return new AppendA(appendable);
  }

  @PostMapping("/dountil/{action}")
  public Object doUntil(@PathVariable String action, @RequestBody(required = false) Until jsonUntil ) {
    logService.save(new Log("/dountil/{action}", "action=" + action + "&json=" + jsonToString(jsonUntil)));
    if ((action.equals("sum")) || (action.equals("factor"))) {
      if (jsonUntil != null) {
        return new DoUntil(action, jsonUntil.getUntil());
      } else {
        return new Error("a number");
      }
    }
    return new Error("the correct method");
  }

  @PostMapping("/arrays")
  public ResponseEntity<Object> calculateFromArray(@RequestBody(required = false) Array calculateArray){
    logService.save(new Log("/arrays", "json=" + jsonToString(calculateArray)));
    if (calculateArray != null){
      if((calculateArray.getWhat() != null) && (calculateArray.getNumbers() != null)) {
        if (calculateArray.getWhat().equals("sum")) {
          Result result = new Result(arrayCalculating.summarize(calculateArray.getNumbers()));
          return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        if (calculateArray.getWhat().equals("multiply")) {
          Result result = new Result(arrayCalculating.multiply(calculateArray.getNumbers()));
          return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        if (calculateArray.getWhat().equals("double")) {
          ResultArray result = new ResultArray(arrayCalculating.doubleTheNumbers(calculateArray.getNumbers()));
          return ResponseEntity.status(HttpStatus.OK).body(result);
        }
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("what to do with the numbers"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("what to do with the numbers"));
  }

  @GetMapping("/log")
  public LogList listTheLogs(){
    return logService.createLogList();
  }

  @PostMapping("/sith")
  public ResponseEntity<Object> reverseTextToSith(@RequestBody InputText text){
    if ((text == null) || (text.getText().equals(""))){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SithError());
    } else {
      String sithText = sithReverserService.reverseTextToSith(text.getText());
      return ResponseEntity.status(HttpStatus.OK).body(new SithText(sithText));
    }
  }



  public String jsonToString(Object object){
    if (object == null){
      return "null";
    } else {
      return object.toString();
    }
  }
}
