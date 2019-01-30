import java.io.Serializable;
import java.time.LocalDateTime;

public class Todo implements Serializable {
  private String description;
  private boolean completed;
  private int id;
  private static int idCounter = 0;
  private LocalDateTime createdAt;
  private LocalDateTime completedAt;

  public Todo(String description) {
    this.description = description;
    this.completed = false;
    idCounter++;
    this.id = idCounter;
    this.completedAt = LocalDateTime.now();
    this.createdAt = LocalDateTime.now();
  }

//  public Todo(String description, boolean isCompleted) {
//    this.description = description;
//    this.completed = isCompleted;
//    idCounter++;
//    this.id = idCounter;
//  }

  public Todo(int id, String description, boolean isCompleted, LocalDateTime createdAt, LocalDateTime completedAt) {
    this.description = description;
    this.completed = isCompleted;
    this.id = id;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
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