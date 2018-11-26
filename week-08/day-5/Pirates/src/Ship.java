import java.util.ArrayList;

public class Ship {
  private String nameOfShip;
  private ArrayList<Pirate> crew;
  private int crewSize;
  private int numberOfAlivePirates;
  private int numberOfAwakePirates;


  public Ship(String name) {
    this.nameOfShip = name;
    this.crew = new ArrayList<>();
  }

  public void fillShip() {
    this.crew.add(new Pirate(true));
    crewSize = (int)(Math.random() * 100);
    for (int i = 0; i < crewSize; i++) {
      this.crew.add(new Pirate());
    }
    this.numberOfAlivePirates = crew.size();
    this.numberOfAwakePirates = crew.size();
  }

  public int checkNumberOfAlivePirates() {
    numberOfAlivePirates = 0;
    for (int i = 0; i < crew.size(); i++){
      if (crew.get(i).isAlive()) {
        numberOfAlivePirates++;
      }
    }
    return numberOfAlivePirates;
  }

  public int checkNumberOfAwakePirates() {
    numberOfAwakePirates = 0;
    for (int i = 0; i < crew.size(); i++){
      if (crew.get(i).isAwake() && crew.get(i).isAlive()) {
        numberOfAwakePirates++;
      }
    }
    return numberOfAwakePirates;
  }

  public boolean battle(Ship anotherShip) {
    if (countScoreOfTheShip(this) > countScoreOfTheShip(anotherShip)) {
      this.winnerGetParty();
      anotherShip.looserHasLosses();
      anotherShip.checkNumberOfAlivePirates();
    } else {
      this.looserHasLosses();
      anotherShip.winnerGetParty();
    }

    this.checkNumberOfAlivePirates();
    this.checkNumberOfAwakePirates();
    anotherShip.checkNumberOfAlivePirates();
    anotherShip.checkNumberOfAwakePirates();
    return (countScoreOfTheShip(this) > countScoreOfTheShip(anotherShip));
  }

  public int countScoreOfTheShip(Ship ship) {
    return ship.numberOfAwakePirates - ship.crew.get(0).getRumLevel();
  }

  public void winnerGetParty() {
    for (int i = 0; i < crew.size(); i++) {
      int consumOfRum = (int) (Math.random() * 10);
      int currentRumLevel = crew.get(i).getRumLevel();
      crew.get(i).setRumLevel(currentRumLevel + consumOfRum);
    }
  }

  public void looserHasLosses() {
    int losses = (int)(Math.random() * numberOfAlivePirates);
    for (int i = 0; i < losses; i++) {
      int indexOfDeath = (int) (Math.random() * crew.size());
      while (!crew.get(indexOfDeath).isAlive()) {
        indexOfDeath = (int) (Math.random() * crew.size());
      }
      crew.get(indexOfDeath).setAlive(false);
    }
  }

  public String getNameOfShip() {
    return nameOfShip;
  }

  public void setNameOfShip(String nameOfShip) {
    this.nameOfShip = nameOfShip;
  }

  public ArrayList<Pirate> getCrew() {
    return crew;
  }

  public void setCrew(ArrayList<Pirate> crew) {
    this.crew = crew;
  }

  public int getCrewSize() {
    return crewSize;
  }

  public void setCrewSize(int crewSize) {
    this.crewSize = crewSize;
  }

  public int getNumberOfAlivePirates() {
    return numberOfAlivePirates;
  }

  public void setNumberOfAlivePirates(int numberOfAlivePirates) {
    this.numberOfAlivePirates = numberOfAlivePirates;
  }

  public int getNumberOfAwakePirates() {
    return numberOfAwakePirates;
  }

  public void setNumberOfAwakePirates(int numberOfAwakePirates) {
    this.numberOfAwakePirates = numberOfAwakePirates;
  }

  @Override
  public String toString() {
    return ("The crew of the " + nameOfShip + " ship consists of the captain and  " + crewSize + " pirates.\n" +
        "Number of alive pirates is: " + numberOfAlivePirates + "\nNumber of awake pirates: " + numberOfAwakePirates +
        "\nThe captain drank: " + crew.get(0).getRumLevel() + " units rum \nHis status is (awake and alive): " + crew.get(0).checkAliveAndAwake() + "\n");
  }
}
