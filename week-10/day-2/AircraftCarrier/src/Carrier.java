import java.util.ArrayList;

public class Carrier {
  ArrayList<Aircraft> carrier;
  private String name;
  private int ammoStorage;
  private int healthPoint;
  private int totalDamage;

  public Carrier (String name, int numberOfAmmo, int healthPoint) {
    carrier = new ArrayList<>();
    this.name = name;
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
        if (carrier.get(i).getActualNumberOfAmmo() != carrier.get(i).getMaxNumberOfAmmo()) {
          ammoStorage = carrier.get(i).refill(ammoStorage);
        }
      }
    }
  }

  public boolean checkIfStorageEmpty() {
    return ammoStorage == 0;
  }

  public void fight(Carrier enemy) {
    this.healthPoint -= enemy.shotAllAmmoOfCarrier();
    enemy.healthPoint -= this.shotAllAmmoOfCarrier();
    if (this.checkIfDead()) {
      System.out.println("The " + this.name + " is dead Jim :(");
    }

    if(enemy.checkIfDead()) {
      System.out.println("The " + enemy.name + " is dead Jim :(");
    }
  }

  public int shotAllAmmoOfCarrier() {
    int causedDamage = 0;
    for (Aircraft aircraft : carrier) {
      causedDamage += aircraft.fight();
      totalDamage += causedDamage;
    }
    return causedDamage;
  }

  public boolean checkIfDead() {
    return healthPoint <= 0;
  }

  public int countTotalDamage() {
    for (Aircraft aircraft : carrier){
      totalDamage += aircraft.getAllDamage();
    }
    return totalDamage;
  }

  public String getStatus() {
    String toPrint = String.format("%s %s:\nHP: %d, Aircraft count: %d, Ammo Storage: %d, Total Damage: %d\nAircrafts:\n",
        this.name,
        this.getClass().getSimpleName(),
        this.healthPoint,
        this.carrier.size(),
        this.ammoStorage,
        this.countTotalDamage());
    for (Aircraft aircraft : carrier) {
      toPrint += (aircraft.getStatus() + "\n");
    }
    return toPrint;
  }

  public ArrayList<Aircraft> getCarrier() {
    return carrier;
  }

  public void setCarrier(ArrayList<Aircraft> carrier) {
    this.carrier = carrier;
  }

  public int getAmmoStorage() {
    return ammoStorage;
  }

  public void setAmmoStorage(int ammoStorage) {
    this.ammoStorage = ammoStorage;
  }

  public int getHealthPoint() {
    return healthPoint;
  }

  public void setHealthPoint(int healthPoint) {
    this.healthPoint = healthPoint;
  }

  public int getTotalDamage() {
    return totalDamage;
  }

  public void setTotalDamage(int totalDamage) {
    this.totalDamage = totalDamage;
  }
}
