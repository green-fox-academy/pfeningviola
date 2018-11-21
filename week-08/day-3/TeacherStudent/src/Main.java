public class Main {
  public static void main(String[] args) {
    Teacher Katie = new Teacher("Katie", "geography");
    Teacher John = new Teacher("John", "Math");

    Student Ross = new Student("Ross", 100);
    Student Mary = new Student("Mary", 120);

    Katie.teach(Ross);
    System.out.println(Ross);
    System.out.println(Katie);

    Mary.question(John);
    System.out.println(John);
    System.out.println(Mary);
  }
}
