package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AccountController {
  private BankAccount simba = new BankAccount("Simba",2000,"lion", true, true);
  private ArrayList<BankAccount> accountList = new ArrayList<>();

  public AccountController() {
    accountList.add(new BankAccount("Simba",300,"lion", true, true));
    accountList.add(new BankAccount("Zordon",100,"lion", false, false));
    accountList.add(new BankAccount("Ed",3,"hyena", false, false));
    accountList.add(new BankAccount("Timon",10,"meerkat", false, true));
    accountList.add(new BankAccount("Pumba",15,"warthog", false, true));
    accountList.add(new BankAccount("Zazu",50,"hornbill", false, true));
    accountList.add(new BankAccount("Nala",200,"lion", false, true));
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

  @GetMapping("/showwithking")
  public String showAccountsWithKing(Model model) {
    model.addAttribute("listaccounts", accountList);
    return "accountswithking";
  }


}
