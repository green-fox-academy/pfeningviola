import java.util.ArrayList;

public class Woods {
  private ArrayList<Tree> woods;

  public Woods() {
    this.woods = new ArrayList<>();
  }

  public void add(Tree tree) {
    this.woods.add(tree);
  }

  public ArrayList<Tree> getWoods() {
    return woods;
  }

  public void setWoods(ArrayList<Tree> woods) {
    this.woods = woods;
  }

  @Override
  public String toString() {
    return "Woods{" +
        "woods=" + woods +
        '}';
  }
}
