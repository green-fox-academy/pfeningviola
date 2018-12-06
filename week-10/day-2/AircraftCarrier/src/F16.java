public class F16 extends Aircraft {
  public static final String type = "F16";
  public static final int maxNumberOfAmmo = 8;
  public static final int baseDamage = 30;
  public static final boolean priority = false;

  public F16() {
    super(type, maxNumberOfAmmo, baseDamage, priority);
    setMaxNumberOfAmmo(8);
    setBaseDamage(30);
    setPriority(false);
  }
}
