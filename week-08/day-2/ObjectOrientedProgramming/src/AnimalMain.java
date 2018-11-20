public class AnimalMain {
  public static void main(String[] args) {
    Animal dog = new Animal();
    Animal cat = new Animal();
    Animal bunny = new Animal();

    System.out.println(dog);
    dog.eat();
    System.out.println(dog);

    System.out.println(cat);
    cat.play();
    System.out.println(cat);

    System.out.println(bunny);
    bunny.drink();
    System.out.println(bunny);
  }
}
