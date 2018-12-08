public class Shifter implements CharSequence {
  private String text;
  private int shiftNumber;

  public Shifter(String text, int number) {
    this.text = text;
    this.shiftNumber = number;
  }

  @Override
  public int length() {
    char[] textCharArray = text.toCharArray();
    return textCharArray.length;
  }

  @Override
  public char charAt(int index) {
    char[] textCharArray = text.toCharArray();
    return textCharArray[index + shiftNumber];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    char[] textCharArray = text.toCharArray();
    String solution = "";
    for (int i = 0; i < end - start; i++) {
      solution += textCharArray[start + shiftNumber + i];
    }
    return solution;
  }
}
