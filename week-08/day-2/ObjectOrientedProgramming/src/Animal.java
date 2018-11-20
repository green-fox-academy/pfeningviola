public class Animal {
  private int hunger;
  private int thurst;

  public Animal() {
    this.hunger = 50;
    this.thurst = 50;
  }

  public void eat() {
    hunger--;
  }

  public void drink() {
    thurst--;
  }

  public void play() {
    hunger++;
    thurst++;
  }

  public int getHunger() {
    return hunger;
  }

  public void setHunger(int hunger) {
    this.hunger = hunger;
  }

  public int getThurst() {
    return thurst;
  }

  public void setThurst(int thurst) {
    this.thurst = thurst;
  }

  @Override
  public String toString() {
    return "Animal{" +
        "hunger=" + hunger +
        ", thurst=" + thurst +
        '}';
  }
}
