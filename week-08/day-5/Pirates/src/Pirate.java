public class Pirate {
  private int rumLevel;
  private boolean captain;
  private boolean alive;
  private boolean awake;

  public Pirate(Boolean captain) {
     this.rumLevel = 0;
     this.captain = captain;
     this.alive = true;
     this.awake = true;
  }

  public Pirate(){
    this.rumLevel = 0;
    this.captain = false;
    this.alive = true;
    this.awake = true;
  }

  public void drinkSomeRum() {
    if (checkAlive() && checkAwake()) {
      this.rumLevel++;
    }
  }

  public void howsItGoingMate() {
    if (checkAlive() && checkAwake()) {
      if (rumLevel < 5) {
        System.out.println("Pour me anudder!");
      } else {
        System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        this.awake = false;
      }
    }
  }

   public void die() {
    this.alive = false;
   }

   public void brawl (Pirate otherPirate) {
    int whoWin = (int)(Math.random() * 3);
    if (this.checkAlive() && this.checkAwake() && otherPirate.checkAlive() && checkAwake()) {
      if (whoWin == 0){
        this.alive = false;
      } else if (whoWin == 1) {
        otherPirate.alive = false;
      } else {
        this.awake = false;
        otherPirate.awake = false;
      }
    }
   }

   public boolean checkAlive() {
     if (!this.alive) {
       System.out.println("He's died.");
     }
     return this.alive;
   }

   public boolean checkAwake() {
    if (checkAlive()) {
      if (!this.awake) {
        System.out.println("He's passed out!");
      }
      this.awake = false;
    }
     return this.awake;
   }

  public int getRumLevel() {
    return rumLevel;
  }

  public void setRumLevel(int rumLevel) {
    this.rumLevel = rumLevel;
  }

  public boolean isCaptain() {
    return captain;
  }

  public void setCaptain(boolean captain) {
    this.captain = captain;
  }

  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public boolean isAwake() {
    return awake;
  }

  public void setAwake(boolean awake) {
    this.awake = awake;
  }

  @Override
  public String toString() {
    return "Pirate{" +
        "Amount of drunk rum: " + rumLevel +
        ", captain=" + captain +
        ", alive=" + alive +
        ", awake=" + awake +
        '}';
  }
}
