package main.java.music;

public class ElectricGuitar extends StringedInstrument {
  public static final String name = "Electric Guitar";

  public ElectricGuitar() {
    super(name, 6);
  }

  public ElectricGuitar(int numOfStrings) {
    super(name, numOfStrings);
  }

  @Override
  public String sound() {
    return "Twang";
  }
}
