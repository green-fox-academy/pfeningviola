package com.greenfoxacademy.dependencies.controllers;

import com.greenfoxacademy.dependencies.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
