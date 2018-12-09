public class Todo implements Printable {
  private String name;
  private boolean completed;

  public Todo(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public void printAllFields() {
    System.out.println(String.format("The name of task: %s\tCompleted: %s", name, completed));
  }
}
