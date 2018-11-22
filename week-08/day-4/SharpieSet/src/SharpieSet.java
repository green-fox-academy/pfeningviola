import java.util.ArrayList;

public class SharpieSet {
  private ArrayList<Sharpie> sharpieSet;

  public SharpieSet() {
    this.sharpieSet = new ArrayList<>();
  }

  public void add(Sharpie sharpie) {
    this.sharpieSet.add(sharpie);
  }

  public int countUsable(){
    int counter = 0;
    for (Sharpie sharpie : this.sharpieSet) {
      if (sharpie.getInkAmount() != 0) {
        counter++;
      }
    }
    return counter;
  }

  public void removeTrash() {
    for (int i = 0; i < sharpieSet.size(); i++) {
      if (sharpieSet.get(i).getInkAmount() == 0) {
        this.sharpieSet.remove(sharpieSet.get(i));
      }
    }
  }

  public ArrayList<Sharpie> getSharpieSet() {
    return sharpieSet;
  }

  public void setSharpieSet(ArrayList<Sharpie> sharpieSet) {
    this.sharpieSet = sharpieSet;
  }

  @Override
  public String toString() {
    return "SharpieSet{" +
        "sharpieSet=" + sharpieSet +
        '}';
  }
}
