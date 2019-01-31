import java.io.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TodoList implements Serializable {
  private ArrayList<Todo> todoList;
  private static final String FILENAME = "todo.txt";

  public TodoList() {
    this.todoList = new ArrayList<>();
  }

  public void add(String todo) {
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    this.todoList.add(new Todo(todo));
    FileIOTask.writeToFile2(this, FILENAME);
  }

  public void list(){
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    TodoList listOfUncompletedTasks = new TodoList();
    if (todoList.isEmpty()) {
      System.out.println("No todos for today! :)");
    } else {
      for (int i = 0; i < todoList.size(); i++) {
        if (!this.todoList.get(i).isCompleted()) {
          listOfUncompletedTasks.getTodoList().add(this.todoList.get(i));
        }
      }
      System.out.println(listOfUncompletedTasks.toString());
    }
  }

  public void listAll(){
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    if (todoList.isEmpty()) {
      System.out.println("No todos for today! :)");
    } else {
      System.out.println(this.toString());
    }
  }

  public void remove (int number) {
    int indexToRemove = number - 1;
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    this.todoList.remove(indexToRemove);
    FileIOTask.writeToFile2(this, FILENAME);
  }

  public void changeStatus(int number) {
    int indexToChange = number - 1;
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    this.todoList.get(indexToChange).setCompletedAt(LocalDateTime.now(Clock.systemUTC()));
    FileIOTask.writeToFile2(this, FILENAME);
  }

  public void update(int id, String newDescription) {
    this.todoList = FileIOTask.readFromFile2(FILENAME).getTodoList();
    int indexToUpdate = findIndexForID(id);
    if (indexToUpdate == -1) {
      System.out.println("The given ID is not found");
    } else {
      this.todoList.get(indexToUpdate).setDescription(newDescription);
    }
    FileIOTask.writeToFile2(this, FILENAME);
  }

  public int findIndexForID(int id) {
    int index = -1;
    for (Todo task : todoList) {
      if (task.getId() == id) {
        index = todoList.indexOf(task);
      }
    }
    return index;
  }


  public ArrayList<Todo> getTodoList() {
    return todoList;
  }

  public String toString() {
    String list = "";
    for (int i = 0; i < todoList.size(); i++) {
      list += (i + 1) + ". " + todoList.get(i) + "\n";
    }
    return list;
  }
}
