public class Animal {
  private int hunger;
  private int thirst;

  public Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public int eat() {
    if (hunger > 0) {
      return hunger -= 1;
    } else {
      return hunger = 0;
    }
  }

  public int drink() {
    if (thirst > 0) {
      return thirst -= 1;
    } else {
      return thirst = 0;
    }
  }

  public void play() {
    hunger++;
    thirst++;
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }
}
