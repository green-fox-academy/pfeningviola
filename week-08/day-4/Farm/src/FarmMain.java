public class FarmMain {
  public static void main(String[] args) {
    Farm donaDulce = new Farm(10);
    for (int i = 0; i < 8; i++) {
      donaDulce.add(new Animal());
    }

    System.out.println(donaDulce);
    System.out.println("-------------------");

    donaDulce.getListOfAnimals().get(3).play();
    donaDulce.getListOfAnimals().get(2).eat();
    System.out.println(donaDulce);
    System.out.println("---------------------");

    donaDulce.breed();
    donaDulce.breed();
    donaDulce.breed();
    donaDulce.slaughter();
    System.out.println(donaDulce);
  }
}
