package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloDifferentLanguagesController {

  @RequestMapping("/greeting/languages")
  public String greeting(Model model, @RequestParam String name){
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
        "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
        "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
        "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
    String randomGreetingInOtherLanguage = hellos[(int)(Math.random() * hellos.length)];
    int randomFontSize = (int)(Math.random() * 100) + 12;
    int randomR = (int)(Math.random() * 256);
    int randomG = (int)(Math.random() * 256);
    int randomB = (int)(Math.random() * 256);
    String randomStyle = "color:rgb(" + randomR + ", " + randomG + ", " + randomB + "); font-size: " + randomFontSize + "px";

    model.addAttribute("name", name);
    model.addAttribute("greetingInOtherLanguage", "<span style ='" + randomStyle + "'>" + randomGreetingInOtherLanguage + "</span>");
    return "greetingLanguages";
  }
}
