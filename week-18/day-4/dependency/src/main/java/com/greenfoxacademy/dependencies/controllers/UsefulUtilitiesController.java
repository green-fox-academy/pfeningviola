package com.greenfoxacademy.dependencies.controllers;

import com.greenfoxacademy.dependencies.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulUtilitiesController {
  private UtilityService utilityService;

  @Autowired
  public UsefulUtilitiesController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String showLinksToUtilities() {
    return "utilitieslinks";
  }

  @GetMapping("/useful/colored")
  public String renderColoredBackground(Model model) {
    model.addAttribute("backgroundColor", utilityService.randomColor());
    return "coloredbackground";
  }

  @GetMapping("/useful/email")
  public String renderEmailValidation(Model model, @RequestParam(name="email", required = false) String email) {
    if (email != null) {
      model.addAttribute("checkValidEmail", utilityService.checkValidEmail(email));
      model.addAttribute("email", email);
    } else {
      model.addAttribute("error", "No given email in the link");
    }
    return "emailvalidator";
  }

  @GetMapping("/useful/encoder")
  public String renderCesearEncoder(Model model, @RequestParam(required = false) String text, Integer number){
    if (text != null) {
      model.addAttribute("encodedText", utilityService.caesar(text, number));
    } else {
      model.addAttribute("error", "There is no text to encode.");
    }
    return "ceasarencoder";
  }

  @GetMapping("/useful/decoder")
  public String renderCesearDecoder(Model model, @RequestParam(required = false) String text, Integer number){
    if (text != null) {
      model.addAttribute("decodedText", utilityService.caesar(text, number * -1));
    } else {
      model.addAttribute("error", "There is no text to decode.");
    }
    return "ceasardecoder";
  }

}
