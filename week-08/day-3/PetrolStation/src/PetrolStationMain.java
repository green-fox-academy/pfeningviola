public class PetrolStationMain {
  public static void main(String[] args) {
    Car suzuki = new Car();
    Station mol = new Station(5000);

    System.out.println(suzuki);
    System.out.println(mol);
    System.out.println("--------------------");

    mol.refill(suzuki);
    System.out.println(suzuki);
    System.out.println(mol);
    System.out.println("--------------------");

    suzuki.run();
    suzuki.run();
    System.out.println(suzuki);
    System.out.println("--------------------");

    mol.refill(suzuki);
    System.out.println(suzuki);
    System.out.println(mol);
  }
}
