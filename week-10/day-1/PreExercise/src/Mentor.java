public class Mentor {
  private String name;
  private int age;
  private String gender;
  private String level;

  public Mentor(String name, int age, String gender, String level) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.level = level;
  }

  public Mentor(){
    name = "Jane Doe";
    age = 30;
    gender = "female";
    level = "intermediate";
  }

  public void introduce() {
    System.out.println("Hi, I'm " + name + ", a " + age + " old " + gender + " " + level + " mentor.");
  }

  public void getGoal(){
    System.out.println("Educate brilliant junior software developers.");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}
