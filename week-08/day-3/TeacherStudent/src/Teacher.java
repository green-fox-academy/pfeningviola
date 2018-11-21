public class Teacher {
  private String name;
  private String object;
  private int teacherExperience;

  public Teacher (String name, String object) {
    this.name = name;
    this.object = object;
    teacherExperience = 0;
  }

  public void teach(Student name) {
    name.learn();
    teacherExperience++;
  }

  public void answer() {
    teacherExperience++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public int getTeacherExperience() {
    return teacherExperience;
  }

  public void setTeacherExperience(int teacherExperience) {
    this.teacherExperience = teacherExperience;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "name='" + name + '\'' +
        ", object='" + object + '\'' +
        ", teacherExperience=" + teacherExperience +
        '}';
  }
}
