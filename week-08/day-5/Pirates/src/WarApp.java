public class WarApp {
  public static void main(String[] args) {
    Armada black = new Armada("black");
    Armada white = new Armada("white");

    System.out.println(black);
    System.out.println("------------------------");
    System.out.println(white);

    System.out.println("-----------------------------");
    System.out.println("The black armada won:" + black.war(white));
    System.out.println(black);
    System.out.println("--------------------------");
    System.out.println(white);
  }
}
