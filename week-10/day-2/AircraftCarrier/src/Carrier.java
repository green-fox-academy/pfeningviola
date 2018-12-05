import java.util.ArrayList;

public class Carrier {
  ArrayList<Aircraft> carrier;
  int ammoStorage;
  int healthPoint;
  int totalDamage;

  public Carrier (int numberOfAmmo, int healthPoint) {
    carrier = new ArrayList<>();
    this.ammoStorage = numberOfAmmo;
    this.healthPoint = healthPoint;
    this.totalDamage = 0;
  }

  public void add(Aircraft aircraft) {
    carrier.add(aircraft);
  }

  public void fill() {
    for (int i = 0; i < carrier.size(); i++) {
      if (checkIfStorageEmpty()) {
        System.out.println("The storage is empty!");
      } else {
        if ((carrier.get(i).isPriority()) && (carrier.get(i).getActualNumberOfAmmo() != carrier.get(i).getMaxNumberOfAmmo())) {
          ammoStorage = carrier.get(i).refill(ammoStorage);
        }
      }
    }
    for (int i = 0; i < carrier.size(); i++) {
      if (checkIfStorageEmpty()) {
        System.out.println("The storage is empty!");
      } else {
        if ((!carrier.get(i).isPriority()) && (carrier.get(i).getActualNumberOfAmmo() != carrier.get(i).getMaxNumberOfAmmo())) {
          ammoStorage = carrier.get(i).refill(ammoStorage);
        }
      }
    }
  }

  public boolean checkIfStorageEmpty() {
    return ammoStorage == 0;
  }
}
