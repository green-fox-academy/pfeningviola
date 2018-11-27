public class String1 {
  
  public static void main(String[] args) {
    String textToChange = "hgxxxxxttttddddxxxxx";
    System.out.println(changeXToY(textToChange));
  }

  public static String changeXToY(String text) {
    StringBuilder changedText = new StringBuilder(text);
    if (text.contains("x")) {
      int index = text.indexOf('x');
      changedText.setCharAt(index, 'y');
      return changeXToY(changedText.toString());
    }
    return changedText.toString();
  }
}
