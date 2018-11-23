public class Tree {
  private String type;
  private String leafColor;
  private int age;
  private String sex;

  public Tree(String type, String leafColor, int age, String sex) {
    this.type = type;
    this.leafColor = leafColor;
    this.age = age;
    this.sex = sex;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLeafColor() {
    return leafColor;
  }

  public void setLeafColor(String leafColor) {
    this.leafColor = leafColor;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "Tree{" +
        "type='" + type + '\'' +
        ", leafColor='" + leafColor + '\'' +
        ", age=" + age +
        ", sex='" + sex + '\'' +
        '}';
  }
}
