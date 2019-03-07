import java.util.HashMap;

public class NumberConverter {
  private HashMap<String, String> mapOfNumbersUnder20;
  private HashMap<String, String> mapOfNumbersFrom20Till99;

  public NumberConverter() {
    mapOfNumbersUnder20 = initMap();
    mapOfNumbersFrom20Till99 = initMap2();
  }


  public String convertNumber(String toConvert) {
    if ((toConvert == null) || (toConvert.isEmpty())) {
      return "No given amount.";
    }

    String digitString = findDigits(toConvert);

    if ((digitString.equals("1")) || (digitString.equals("0"))) {
      return mapOfNumbersUnder20.get(digitString) + " dollar";
    } else if (checkLengthOfNumber(toConvert) <= 3) {
      return convertNumberUntil1000(digitString) + " dollars";
    } else if (checkLengthOfNumber(toConvert) <= 6) {
      return convertNumberBetween1000And1Million(digitString) + " dollars";
    }
    return "Not able to convert.";
  }

  public String convertNumberBetween1000And1Million(String digitString){
    String firstThreeDigits = digitString.substring(0, digitString.length() - 3);
    String secondThreeDigits = digitString.substring(digitString.length() - 3);
    String firstThreeDigitsWithLetters = convertNumberUntil1000(firstThreeDigits);

    if (secondThreeDigits.equals("000")){
      return firstThreeDigitsWithLetters + " thousand";
    } else if (secondThreeDigits.substring(0, 2).equals("00")){
      return firstThreeDigitsWithLetters + " thousand and " + convertNumberUntil1000(secondThreeDigits.substring(2));
    } else if (secondThreeDigits.substring(0, 1).equals("0")){
      return firstThreeDigitsWithLetters + " thousand and " + convertNumberUntil1000(secondThreeDigits.substring(1));
    } else {
      return firstThreeDigitsWithLetters + " thousand " + convertNumberUntil1000(secondThreeDigits);
    }
  }

  public String convertNumberUntil1000(String digitString) {
    if (digitString.length() <= 2) {
      return convertLastTwoDigits(digitString);
    } else {
      return convertThreeDigits(digitString);
    }
  }

  private String convertThreeDigits(String digitString) {
    String hundredDigit = String.valueOf(digitString.charAt(0));
    String beforeLastDigit = String.valueOf(digitString.charAt(digitString.length() - 2));
    String lastDigit = String.valueOf(digitString.charAt(digitString.length() - 1));
    String hundredDigitWithLetters = mapOfNumbersUnder20.get(hundredDigit);
    String lastTwoDigitsWithLetters = convertLastTwoDigits(digitString);
    String lastDigitWithLetters = mapOfNumbersUnder20.get(lastDigit);

    if ((beforeLastDigit.equals("0")) && (lastDigit.equals("0"))){
      return hundredDigitWithLetters + " hundred";
    } else if (beforeLastDigit.equals("0")) {
      return hundredDigitWithLetters + " hundred and " + lastDigitWithLetters;
    } else {
      return hundredDigitWithLetters + " hundred and " + lastTwoDigitsWithLetters;
    }
  }

  public String convertLastTwoDigits(String digitString) {
    int digitInt = Integer.parseInt(digitString);

    if (digitInt < 20) {
      return mapOfNumbersUnder20.get(digitString);
    } else {
      String beforeLastDigit = findBeforeLastDigitWithLetters(digitString);
      String lastDigit = mapOfNumbersUnder20.get(String.valueOf(digitString.charAt(digitString.length() - 1)));
      if (digitString.charAt(digitString.length() - 1) == '0') {
        return beforeLastDigit;
      } else {
        return beforeLastDigit + "-" + lastDigit;
      }
    }
  }

  private String findBeforeLastDigitWithLetters(String digitString) {
    char beforeLastDigit = digitString.charAt(digitString.length() - 2);
    return mapOfNumbersFrom20Till99.get(String.valueOf(beforeLastDigit));
  }

  public String findDigits(String toConvert) {
    return toConvert.substring(0, checkLengthOfNumber(toConvert));
  }

  public int checkLengthOfNumber(String toConvert) {
    return toConvert.length() - 5;
  }

  public HashMap<String, String> initMap() {
    HashMap<String, String> mapOfNumbers = new HashMap<>();
    mapOfNumbers.put("0", "zero");
    mapOfNumbers.put("1", "one");
    mapOfNumbers.put("2", "two");
    mapOfNumbers.put("3", "three");
    mapOfNumbers.put("4", "four");
    mapOfNumbers.put("5", "five");
    mapOfNumbers.put("6", "six");
    mapOfNumbers.put("7", "seven");
    mapOfNumbers.put("8", "eight");
    mapOfNumbers.put("9", "nine");
    mapOfNumbers.put("10", "ten");
    mapOfNumbers.put("11", "eleven");
    mapOfNumbers.put("12", "twelve");
    mapOfNumbers.put("13", "thirteen");
    mapOfNumbers.put("14", "fourteen");
    mapOfNumbers.put("15", "fifteen");
    mapOfNumbers.put("16", "sixteen");
    mapOfNumbers.put("17", "seventeen");
    mapOfNumbers.put("18", "eighteen");
    mapOfNumbers.put("19", "nineteen");
    return mapOfNumbers;
  }

  private HashMap<String, String> initMap2() {
    HashMap<String, String> mapOfNumbers = new HashMap<>();

    mapOfNumbers.put("2", "twenty");
    mapOfNumbers.put("3", "thirty");
    mapOfNumbers.put("4", "forty");
    mapOfNumbers.put("5", "fifty");
    mapOfNumbers.put("6", "sixty");
    mapOfNumbers.put("7", "seventy");
    mapOfNumbers.put("8", "eighty");
    mapOfNumbers.put("9", "ninety");
    return mapOfNumbers;
  }
}