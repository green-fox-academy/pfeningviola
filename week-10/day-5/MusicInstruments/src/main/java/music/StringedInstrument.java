package main.java.music;

public abstract class StringedInstrument extends Instrument {
  int numberOfStrings;

  public StringedInstrument(String name, int numberOfStrings){
    super(name);
    this.numberOfStrings = numberOfStrings;
  }

  @Override
  public void play() {
    System.out.println(String.format("%s, %d-stringed instrument that goes %s",
        name,
        numberOfStrings,
        sound()));
  }

  public abstract String sound();
}
