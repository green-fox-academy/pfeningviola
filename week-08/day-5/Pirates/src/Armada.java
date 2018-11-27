import java.util.ArrayList;

public class Armada {
  private ArrayList<Ship> armada;
  private int armadaSize;
  private String armadaName;

  public Armada(String name) {
    this.armadaName = name;
    this.armada = new ArrayList<>();
    armadaSize = (int)(Math.random() * 10) + 1;
    int numberOfTheShip = 1;
    for (int i = 0; i < armadaSize; i++) {
      this.armada.add(new Ship(String.valueOf(numberOfTheShip)));
      numberOfTheShip++;
    }
  }

  public boolean war(Armada otherArmada) {

    while ((this.armada.size() != 0) && (otherArmada.armada.size() != 0)) {
      while ((otherArmada.armada.size() != 0) && (this.armada.get(0).battle(otherArmada.armada.get(0)))) {
        otherArmada.getArmada().remove(0);
        System.out.println(this.armadaName + " won the battle.");
      }
      this.armada.remove(0);
      System.out.println(otherArmada.getArmadaName() + " won the battle.");
    }
    return this.armada.size() > 0;
  }

  public ArrayList<Ship> getArmada() {
    return armada;
  }

  public void setArmada(ArrayList<Ship> armada) {
    this.armada = armada;
  }

  public String getArmadaName() {
    return armadaName;
  }

  public void setArmadaName(String armadaName) {
    this.armadaName = armadaName;
  }

  @Override
  public String toString() {
    return "The " + armadaName + " armada has "
        + armada.size() + " ships:\n";
  }
}
