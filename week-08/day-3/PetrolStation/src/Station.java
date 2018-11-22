public class Station {
  private int gasAmount;

  public Station (int gasAmount) {
    this.gasAmount = gasAmount;
  }

  public void refill(Car car) {
    this.gasAmount -= (car.getCapacity() - car.getGasAmount());
    car.setGasAmount(100);
  }

  public int getGasAmount() {
    return gasAmount;
  }

  public void setGasAmount(int gasAmount) {
    this.gasAmount = gasAmount;
  }

  @Override
  public String toString() {
    return "Station{" +
        "gasAmount=" + gasAmount +
        '}';
  }
}
