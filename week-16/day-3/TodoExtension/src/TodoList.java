import java.io.*;
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
    this.todoList.get(indexToChange).setCompletedAt(LocalDateTime.now());
    FileIOTask.writeToFile2(this, FILENAME);
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
