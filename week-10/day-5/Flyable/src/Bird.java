public class Bird extends Animal implements Flyable {
  public static final String name = "Bird";

  private String typeOfNest;
  private int avarageWingspan;
  private int broodingPeriod;

  public Bird(){
    super(name);
  }

  @Override
  public String breed() {
      return "laying eggs";
    }

  @Override
  public void takeOff() {
    System.out.println("Csip-csirip");
  }

  @Override
  public void fly() {
    System.out.println("The Bird is flying...");
  }

  @Override
  public void land() {
    System.out.println("Csip-csip-csip");
  }
}
