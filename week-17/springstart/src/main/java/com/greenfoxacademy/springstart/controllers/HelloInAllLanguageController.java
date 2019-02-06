package com.greenfoxacademy.springstart.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HelloInAllLanguageController {
  @RequestMapping("/greeting/alllanguages")
  public String greeting(Model model, @RequestParam String name){
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
        "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
        "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
        "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
    ArrayList<String> randomGreetings = orderGreetingsRandomly(hellos);
    String textToDisplay = "";

    for (String greeting : randomGreetings) {
      textToDisplay = textToDisplay + "<span style ='" + styleRandom() + "'>" + greeting + ", " + name + "! </span>";
    }
    model.addAttribute("greetingsToDisplay", textToDisplay);
    return "greetingLanguages2";
  }

  public ArrayList<String> orderGreetingsRandomly(String[] greetings){
    ArrayList<String> originalGreetings = new ArrayList<>();
    ArrayList<String> randomGreetings = new ArrayList<>();
    for (String greeting : greetings) {
      originalGreetings.add(greeting);
    }

    while (originalGreetings.size() != 0) {
      int index = (int)(Math.random() * originalGreetings.size());
      randomGreetings.add(originalGreetings.get(index));
      originalGreetings.remove(index);
    }

    return randomGreetings;
  }

  public String styleRandom() {
    int randomFontSize = (int)(Math.random() * 100) + 12;
    int randomR = (int)(Math.random() * 256);
    int randomG = (int)(Math.random() * 256);
    int randomB = (int)(Math.random() * 256);
    return "color:rgb(" + randomR + ", " + randomG + ", " + randomB + "); font-size: " + randomFontSize + "px";
  }
}
