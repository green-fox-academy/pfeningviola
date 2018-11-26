public class BattleApp {
  public static void main(String[] args) {
    Ship santaMaria = new Ship("Santa Maria");
    Ship blackPearl = new Ship("Black Pearl");
    santaMaria.fillShip();
    blackPearl.fillShip();

    System.out.println(santaMaria);
    System.out.println(blackPearl);
    System.out.println("------------------------");

    System.out.println("Santa Maria won the battle: " + santaMaria.battle(blackPearl));
    System.out.println(santaMaria);
    System.out.println(blackPearl);

    for (int i = 0; i < 20; i++) {
      santaMaria.getCrew().get(0).drinkSomeRum();
    }

    santaMaria.getCrew().get(0).howsItGoingMate();
    System.out.println(santaMaria.getCrew().get(0).checkAliveAndAwake());
    santaMaria.getCrew().get(0).die();
    System.out.println(santaMaria);
    System.out.println("-------------------------");
    System.out.println("Santa Maria won the battle: " + santaMaria.battle(blackPearl));
    System.out.println(santaMaria);
    System.out.println(blackPearl);
  }

}
