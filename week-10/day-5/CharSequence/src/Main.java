public class Main {
  public static void main(String[] args) {
    Gnirts text = new Gnirts("implementation");
    System.out.println(text.length());
    System.out.println(text.charAt(1));
    System.out.println(text.subSequence(2, 6));
  }
}
