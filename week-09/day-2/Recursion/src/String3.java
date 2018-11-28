public class String3 {
  public static void main(String[] args) {
    String text = "Hello";
    int indexOfLastChar = text.length()- 1 ;
    System.out.println(addWildcards(text, indexOfLastChar));
  }

  private static String addWildcards(String text, int indexOfCheckedChar) {
    if (indexOfCheckedChar == 0) {
      return text.charAt(0) + "*";
    } else if (indexOfCheckedChar == text.length() - 1) {
      return addWildcards(text, indexOfCheckedChar - 1) + text.charAt(indexOfCheckedChar);
    } else {
      return addWildcards(text,indexOfCheckedChar - 1) + text.charAt(indexOfCheckedChar) + "*";
    }
  }
}
