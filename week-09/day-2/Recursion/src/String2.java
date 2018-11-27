public class String2 {
  public static void main(String[] args) {
    String text = "wxxxnjtghfmxxxthgnxxskgxx";
    System.out.println(removeX(text));
  }

  private static String removeX(String text) {
    StringBuilder changedText = new StringBuilder(text);
    if (text.contains("x")){
      int index = text.indexOf('x');
      changedText.deleteCharAt(index);
      return removeX(changedText.toString());
    }
    return changedText.toString();
  }
}
