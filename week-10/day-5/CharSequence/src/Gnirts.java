public class Gnirts implements CharSequence {
  private String text;

  public Gnirts(String text) {
    this.text = text;
  }

  @Override
  public int length() {
    char[] textCharArray = text.toCharArray();
    return textCharArray.length;
  }

  @Override
  public char charAt(int index) {
    char[] textCharArray = text.toCharArray();
    return textCharArray[textCharArray.length - index - 1];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    char[] textCharArray = text.toCharArray();
    String subSequence = "";
    for (int i = 0; i < end - start; i++) {
      subSequence += textCharArray[textCharArray.length - end + i];
    }
    return subSequence;
  }
}
