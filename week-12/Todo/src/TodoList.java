import java.io.*;
import java.util.ArrayList;

public class TodoList implements Serializable {
  private ArrayList<Todo> todoList;

  public TodoList() {
    this.todoList = new ArrayList<>();
  }

  public void add(String todo) {
    this.todoList = FileIOTask.readFromFile().getTodoList();
    this.todoList.add(new Todo(todo));
    FileIOTask.writeToFile(this);
  }

  public void list(){
    this.todoList = FileIOTask.readFromFile().getTodoList();
    if (todoList.isEmpty()) {
      System.out.println("No todos for today! :)");
    } else {
      System.out.println(this.toString());
    }
  }

  public void remove (int number) {
    int indexToRemove = number - 1;
    this.todoList = FileIOTask.readFromFile().getTodoList();
    this.todoList.remove(indexToRemove);
    FileIOTask.writeToFile(this);
  }

  public void changeStatus(int number) {
    int indexToChange = number - 1;
    this.todoList = FileIOTask.readFromFile().getTodoList();
    this.todoList.get(indexToChange).setCompleted();
    FileIOTask.writeToFile(this);
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
