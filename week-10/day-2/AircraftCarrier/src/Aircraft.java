public class Aircraft {
  private String type;
  private int maxNumberOfAmmo;
  private int actualNumberOfAmmo;
  private boolean priority;
  private int baseDamage;
  private int allDamage;

  public Aircraft(String type) {
    this.type = type;
    actualNumberOfAmmo = 0;
    allDamage = 0;
  }


  public String getType() {
    return type;
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

  public boolean isPriority() {
    return priority;
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
