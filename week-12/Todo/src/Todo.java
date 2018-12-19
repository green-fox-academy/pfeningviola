import java.io.Serializable;

public class Todo implements Serializable {
  private String description;
  private boolean completed;

  public Todo(String description) {
    this.description = description;
    this.completed = false;
  }

  public Todo(String description, boolean isCompleted) {
    this.description = description;
    this.completed = isCompleted;
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
