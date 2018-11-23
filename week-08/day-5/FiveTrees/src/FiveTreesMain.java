public class FiveTreesMain {
  public static void main(String[] args) {
    Woods myWoods = new Woods();
    myWoods.add(new Tree("oak", "dark green", 150, "female"));
    myWoods.add(new Tree("beech", "yellow-green", 80, "male"));
    myWoods.add(new Tree("maple", "emerald",15, "male"));
    myWoods.add(new Tree("olive", "olive", 32, "female"));
    myWoods.add(new Tree("pine", "pine green", 78, "male"));

    System.out.println(myWoods);
    System.out.println(myWoods.getWoods());
    System.out.println(myWoods.getWoods().get(3));
    System.out.println(myWoods.getWoods().get(3).getType());
  }
}
