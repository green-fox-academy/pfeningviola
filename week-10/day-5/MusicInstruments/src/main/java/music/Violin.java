package main.java.music;

public class Violin extends StringedInstrument {
  public static final String name = "Violin";

  public Violin(){
    super(name, 4);
  }

  public Violin(int numOfStrings) {
    super(name, numOfStrings);
  }

  @Override
  public String sound() {
    return "Screech";
  }
}
