public class Car {
  private int capacity;
  private int gasAmount;

  public Car(){
    this.capacity = 100;
    this.gasAmount = 0;
  }

  public void run(){
    gasAmount -= 10;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getGasAmount() {
    return gasAmount;
  }

  public void setGasAmount(int gasAmount) {
    this.gasAmount = gasAmount;
  }

  @Override
  public String toString() {
    return "Car{" +
        "capacity=" + capacity +
        ", gasAmount=" + gasAmount +
        '}';
  }
}
