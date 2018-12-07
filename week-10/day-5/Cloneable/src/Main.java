public class Main {
  public static void main(String[] args) {
    Student john = new Student("John", 20, "male", "BMI");
    john.introduce();
    Student johnTheClone = null;

    try {
      johnTheClone = john.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    johnTheClone.introduce();
  }
}
