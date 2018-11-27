public class PirateMain {

  public static void main(String[] args) {
    Pirate captain = new Pirate(true);
    Pirate pirate1 = new Pirate();
    Pirate pirate2 = new Pirate();

    System.out.println(captain);

    for (int i = 0; i < 5; i++) {
      pirate1.drinkSomeRum();
    }
    System.out.println(pirate1);
    pirate1.howsItGoingMate();
    System.out.println(pirate1);
    pirate1.drinkSomeRum();

    System.out.println("---------------------");
    captain.brawl(pirate2);
    System.out.println(pirate2);
    System.out.println(captain);
    pirate2.howsItGoingMate();
    captain.howsItGoingMate();
    System.out.println("------------------------");

    pirate1.die();
    pirate1.drinkSomeRum();
  }
}
