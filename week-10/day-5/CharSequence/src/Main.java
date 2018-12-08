public class Main {
  public static void main(String[] args) {
    Gnirts text = new Gnirts("implementation");
    System.out.println(text.length());
    System.out.println(text.charAt(1));
    System.out.println(text.subSequence(2, 6));

    System.out.println();
    Shifter test = new Shifter("implementation", 2);
    System.out.println(test.length());
    System.out.println(test.charAt(0));
    System.out.println(test.subSequence(1, 4));
  }
}
