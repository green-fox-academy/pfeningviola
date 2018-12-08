package main.java.music;

public class BassGuitar extends StringedInstrument {
  public static final String name = "Bass Guitar";

  public BassGuitar() {
    super(name, 4);
  }

  public BassGuitar(int numOfStrings) {
    super(name, numOfStrings);
  }

  @Override
  public String sound() {
    return "Duum-duum-duum";
  }
}
