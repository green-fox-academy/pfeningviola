public class Main {
  public static void main(String[] args) {
    Flower yellow = new Flower("yellow", 4);
    Flower blue = new Flower("blue", 4);
    Tree purple = new Tree("purple", 4);
    Tree orange = new Tree("orange", 4);

    Garden myGarden = new Garden();
    myGarden.add(yellow);
    myGarden.add(blue);
    myGarden.add(purple);
    myGarden.add(orange);

    System.out.println(myGarden);

    System.out.println();
    System.out.println("Watering with 40:");
    myGarden.waterTheGarden(40);
    System.out.println(myGarden);

    System.out.println();
    System.out.println("Watering with 70:");
    myGarden.waterTheGarden(70);
    System.out.println(myGarden);
  }
}
