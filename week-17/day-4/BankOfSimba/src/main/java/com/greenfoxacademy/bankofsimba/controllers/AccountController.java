package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
  private BankAccount simba = new BankAccount("Simba", 2000, "lion");

  @GetMapping("/show")
  public String showAccounts(Model model){
    model.addAttribute("account", simba);
    return "accounts";
  }
}
