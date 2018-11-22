public class SharpieMain {
  public static void main(String[] args) {
    Sharpie sharpie1 = new Sharpie("yellow", 1.345f);
    sharpie1.use();
    System.out.println(sharpie1);

    SharpieSet sharpies = new SharpieSet();
    sharpies.add(new Sharpie(0f));
    sharpies.add(sharpie1);
    sharpies.add(new Sharpie(10f));
    sharpies.add(new Sharpie(50f));

    System.out.println(sharpies);
    System.out.println(sharpies.countUsable());
    System.out.println("-----------------------");

    sharpies.removeTrash();
    System.out.println(sharpies);
    System.out.println("------------------------");

    sharpies.getSharpieSet().get(1).use();
    System.out.println(sharpies.countUsable());
    sharpies.removeTrash();
    System.out.println(sharpies);
  }
}
