public class Main {
  public static void main(String[] args) {
    Carrier black = new Carrier("Black", 100, 1000);
    for (int i = 0; i < 2; i++) {
      black.add(new F16());
      black.add(new F35());
    }
    System.out.println(black.getStatus());
    black.fill();
    System.out.println(black.getStatus());

    black.getCarrier().get(1).fight();
    black.getCarrier().get(1).refill(30);
    System.out.println(black.getStatus());

    Carrier white = new Carrier("White", 200, 200);
    for (int i = 0; i < 1; i++){
      white.add(new F16());
      white.add(new F35());
    }

    white.fill();
    black.fight(white);
    System.out.println(black.getStatus());
    System.out.println(white.getStatus());
  }
}
