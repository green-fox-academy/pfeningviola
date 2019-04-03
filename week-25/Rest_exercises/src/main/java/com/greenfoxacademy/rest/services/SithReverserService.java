package com.greenfoxacademy.rest.services;

import com.greenfoxacademy.rest.models.Array;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SithReverserService {

  public String reverseTextToSith(String input){
    String[] sentences = input.split("\\.");
    String formattedSentence = "";
    String reversedSithText = "";
    for (String sentence : sentences){
      formattedSentence = swap(sentence);
      reversedSithText = reversedSithText + " " + formattedSentence + " " + yodaText();
    }
    return reversedSithText.trim();
  }

  public String yodaText(){
    ArrayList<String> yodaSentences = new ArrayList<>(Arrays.asList("Arrgh.", "Yes, hmmm.", "Err..err.err.", "Hmm.", "Herh herh herh.", "Yeesssssss."));
    int numberOfYodaWords = 1 + ((int)(Math.random() * 2));
    int indexOfYodaWord = (int)(Math.random() * yodaSentences.size());
    String yodaText = yodaSentences.get((int)(Math.random() * yodaSentences.size()));
    if (numberOfYodaWords == 2){
      yodaText = yodaText + " " + yodaSentences.get((int)(Math.random() * yodaSentences.size()));
    }
    return yodaText;
  }



  public String swap(String sentence){
    ArrayList<String> wordsOfSentence = cutIntoWords(sentence);
    if (wordsOfSentence.size() % 2 == 0){
      wordsOfSentence = swapTheWordWithEven(wordsOfSentence);
    } else {
      wordsOfSentence = swapTheWordWithOdd(wordsOfSentence);
    }
    wordsOfSentence.set(0, firstLetterToUpperCase(wordsOfSentence.get(0)));
    return chainWords(wordsOfSentence);
  }

  public String chainWords(ArrayList<String> sentence){
    String formattedSentence = sentence.get(0);

    for (int i = 1; i < sentence.size(); i++){
      formattedSentence = formattedSentence + " " + sentence.get(i);
    }
    formattedSentence = formattedSentence + ".";
    return formattedSentence;
  }

  public String firstLetterToUpperCase(String word){
    String firstLetter = String.valueOf(word.charAt(0));
    String resultWord = firstLetter.toUpperCase() + word.substring(1);
    return resultWord;
  }

  public ArrayList<String> swapTheWordWithEven(ArrayList<String> words){
    ArrayList<String> swapedSentence = new ArrayList<>();
    for (int i = 0; i < words.size() - 1; i += 2){
      swapedSentence.add(words.get(i + 1));
      swapedSentence.add(words.get(i).toLowerCase());
    }
    return swapedSentence;
  }

  public ArrayList<String> swapTheWordWithOdd(ArrayList<String> words){
    ArrayList<String> swapedSentence = new ArrayList<>();
    for (int i = 0; i < words.size() - 2; i += 2){
      swapedSentence.add(words.get(i + 1));
      swapedSentence.add(words.get(i).toLowerCase());
    }
    swapedSentence.add(words.get(words.size() - 1));
    return swapedSentence;
  }


  public ArrayList<String> cutIntoWords(String sentence){
    ArrayList<String> words = new ArrayList<>();
    String[] wordsInSentence = sentence.trim().split(" ");
    for (String word : wordsInSentence){
      words.add(word);
    }
    return words;
  }



}
