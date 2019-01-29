import java.io.Serializable;

public class Todo implements Serializable {
  private String description;
  private boolean completed;
  private int id;
  private static int idCounter = 0;

  public Todo(String description) {
    this.description = description;
    this.completed = false;
    idCounter++;
    this.id = idCounter;
  }

  public Todo(String description, boolean isCompleted) {
    this.description = description;
    this.completed = isCompleted;
    idCounter++;
    this.id = idCounter;
  }

  public Todo(int id, String description, boolean isCompleted) {
    this.description = description;
    this.completed = isCompleted;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public static int getIdCounter() {
    return idCounter;
  }

  public static void setIdCounter(int idCounter) {
    Todo.idCounter = idCounter;
  }

  public void setCompleted() {
    this.completed = true;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + description;
  }
}