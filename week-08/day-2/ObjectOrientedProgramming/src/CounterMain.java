public class CounterMain {
  public static void main(String[] args) {
    Counter myNumber = new Counter();
    Counter myNumber2 = new Counter(5);

    System.out.println(myNumber);
    myNumber.add();
    myNumber.add(5);
    System.out.println(myNumber);
    System.out.println(myNumber.get());
    myNumber.reset();
    System.out.println(myNumber);

    myNumber2.add(7);
    System.out.println(myNumber2.get());
    System.out.println(myNumber2);
    myNumber2.reset();
    System.out.println(myNumber2);


  }
}
