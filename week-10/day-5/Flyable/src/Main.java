import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Flyable> myList = new ArrayList<>();
    myList.add(new Helicopter());
    myList.add(new Helicopter());
    myList.add(new Bird());
    myList.add(new Bird());

    for (Flyable flyable : myList) {
      flyable.takeOff();
    }
  }
}
