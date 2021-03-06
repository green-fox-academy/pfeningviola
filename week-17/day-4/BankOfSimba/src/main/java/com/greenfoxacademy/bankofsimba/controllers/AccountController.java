package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    model.addAttribute("listOfAccounts", accountList);
    return "accountswithking";
  }

  @GetMapping("/showbadandgoodguys/withswitch")
  public String showBadAndGoodWithSwitch(Model model) {
    model.addAttribute("accountList", accountList);
    return "accountsbybadandgood";
  }

  @GetMapping("/showbadandgoodguys/withoutswitch")
  public String renderBadAndGoodWithoutSwitch(Model model) {
    model.addAttribute("accountList", accountList);
    return "accountswithoutswitch";
  }

  @GetMapping("/balanceraising")
  public String renderRaiseTheBalance(Model model) {
    model.addAttribute("accountList", accountList);
    return "balanceraising";
  }

  @PostMapping("/balanceraising")
  public String raiseBalance(@ModelAttribute(value = "animal-name") String name){
    incrementTheBalance(name);

    return "redirect:/showbadandgoodguys/withoutswitch";
  }

  @GetMapping("/createaccount")
  public String renderCreateAccount() {
    return "createaccount";
  }

  @PostMapping("/createaccount")
  public String addNewAccount(@ModelAttribute(value = "name") String newName,
                              @ModelAttribute(value = "balance") int balance,
                              @ModelAttribute(value = "type") String type,
                              @ModelAttribute(value = "king") String king,
                              @ModelAttribute(value = "goodone") String good){

      accountList.add(new BankAccount(newName, balance, type, Boolean.parseBoolean(king), Boolean.parseBoolean(good)));
    return "redirect:/showbadandgoodguys/withoutswitch";
  }

  public void incrementTheBalance(String name) {
    for (BankAccount account : accountList) {
      if (account.getName().equalsIgnoreCase(name)) {
        if (account.isKing()) {
          account.setBalance(account.getBalance() + 100);
        } else {
          account.setBalance(account.getBalance() + 10);
        }
      }
    }
  }
}
