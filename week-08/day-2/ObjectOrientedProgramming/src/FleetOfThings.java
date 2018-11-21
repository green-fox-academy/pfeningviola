import java.util.ArrayList;
import java.util.List;

public class FleetOfThings {
  public static void main(String[] args) {
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch
    Fleet fleet = new Fleet();
    List<Thing> things = new ArrayList<>();

    things.add(new Thing("Get milk"));
    things.add(new Thing("Remove the obstacles"));
    things.add(new Thing("Stand up"));
    things.add(new Thing("Eat lunch"));

    things.get(2).complete();
    things.get(3).complete();

    for (int i = 0; i < things.size(); i++) {
      fleet.add(things.get(i));
    }
    System.out.println(fleet);
  }
}
