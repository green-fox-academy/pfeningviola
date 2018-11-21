public class Student {
  private String name;
  private int iq;

  public Student(String name, int iq) {
    this.name = name;
    this.iq = iq;
  }

  public void learn() {
    iq++;
  }

  public void question(Teacher name) {
   name.answer();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", iq=" + iq +
        '}';
  }
}
