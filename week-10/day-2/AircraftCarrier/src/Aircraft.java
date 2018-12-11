public class Aircraft {
  private String type;
  private int maxNumberOfAmmo;
  private int actualNumberOfAmmo;
  private boolean priority;
  private int baseDamage;
  private int allDamage;

  public Aircraft(String type, int maxNumberOfAmmo, int baseDamage, boolean priority) {
    this.type = type;
    this.maxNumberOfAmmo = maxNumberOfAmmo;
    this.baseDamage = baseDamage;
    this.priority = priority;
    actualNumberOfAmmo = 0;
    allDamage = 0;
  }

  public int fight() {
    int damageOfFight = actualNumberOfAmmo * baseDamage;
    allDamage += damageOfFight;
    actualNumberOfAmmo = 0;
    return damageOfFight;
  }

  public int refill(int numberOfStoredAmmos) {
    int numberOfMissingAmos = countMissingAmmos();
    if (numberOfMissingAmos < numberOfStoredAmmos) {
      actualNumberOfAmmo = maxNumberOfAmmo;
      return numberOfStoredAmmos - numberOfMissingAmos;
    } else {
      actualNumberOfAmmo += numberOfStoredAmmos;
      return 0;
     }
  }

  public int countMissingAmmos() {
    return maxNumberOfAmmo - actualNumberOfAmmo;
  }

  public boolean isFull(){
    return actualNumberOfAmmo == maxNumberOfAmmo;
  }

  public String getType() {
    return type;
  }

  public String getStatus() {
    return "Type " + type + ", Ammo: " + actualNumberOfAmmo + ", Base Damage: " + baseDamage + ", All Damage: " + allDamage;
  }

  public boolean isPriority() {
    return priority;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getMaxNumberOfAmmo() {
    return maxNumberOfAmmo;
  }

  public void setMaxNumberOfAmmo(int maxNumberOfAmmo) {
    this.maxNumberOfAmmo = maxNumberOfAmmo;
  }

  public int getActualNumberOfAmmo() {
    return actualNumberOfAmmo;
  }

  public void setActualNumberOfAmmo(int actualNumberOfAmmo) {
    this.actualNumberOfAmmo = actualNumberOfAmmo;
  }

  public void setPriority(boolean priority) {
    this.priority = priority;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  public int getAllDamage() {
    return allDamage;
  }

  public void setAllDamage(int allDamage) {
    this.allDamage = allDamage;
  }
}
