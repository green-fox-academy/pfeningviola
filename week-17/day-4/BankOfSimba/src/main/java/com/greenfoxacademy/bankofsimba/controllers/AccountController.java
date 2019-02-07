package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AccountController {
  private BankAccount simba = new BankAccount("Simba",2000,"lion");
  private ArrayList<BankAccount> accountList = new ArrayList<>();

  public AccountController() {
    accountList.add(new BankAccount("Simba",300,"lion"));
    accountList.add(new BankAccount("Zordon",100,"lion"));
    accountList.add(new BankAccount("Ed",3,"hyena"));
    accountList.add(new BankAccount("Timon",10,"meerkat"));
    accountList.add(new BankAccount("Pumba",15,"warthog"));
    accountList.add(new BankAccount("Zazu",50,"hornbill"));
    accountList.add(new BankAccount("Nala",200,"lion"));
  }

  @GetMapping("/show")
  public String showAccount(Model model){
    model.addAttribute("account", simba);
    return "simbaaccount";
  }

  @GetMapping("/showall")
  public String showAllAccount(Model model) {
    model.addAttribute("accountList", accountList);
    return "accounts";
  }


}
