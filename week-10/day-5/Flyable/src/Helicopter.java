public class Helicopter extends Vehicle implements Flyable{
  public static final String type = "Helicopter";

  public Helicopter() {
    super(type);
  }

  @Override
  public void takeOff() {
    System.out.println("dodododododo");
  }

  @Override
  public void fly() {
    System.out.println("The Helicopter is flying...");
  }

  @Override
  public void land() {
    System.out.println("dumdumdumdum");
  }
}
