public class Counter {
  private int number;
  private int defaultNumber;

  public Counter() {
    this.number = 0;
    defaultNumber = 0;
  }

  public Counter(int number) {
    this.number = number;
    defaultNumber = number;
  }

  public void add() {
    number++;
  }

  public void add(int valueToAdd) {
    this.number += valueToAdd;
  }

  public int get() {
    return number;
  }

  public void reset() {
    this.number = defaultNumber;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Counter{" +
        "number=" + number +
        '}';
  }
}
