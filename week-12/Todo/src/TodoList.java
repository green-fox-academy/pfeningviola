import java.io.*;
import java.util.ArrayList;

public class TodoList implements Serializable {
  private ArrayList<Todo> todoList;

  public TodoList() {
    todoList = new ArrayList<>();
  }

  public void add(String todo) {
    this.todoList.add(new Todo(todo));
    writeToFile(this);
  }

  public void writeToFile(TodoList tasks) {
    String fileName = "todo.txt";
    try {
      FileOutputStream fileOutputStream
          = new FileOutputStream(fileName);
      ObjectOutputStream objectOutputStream
          = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(tasks);
      objectOutputStream.flush();
      objectOutputStream.close();
    } catch (IOException e) {
      System.out.println("Unable to write into file!");
    }
  }

  public TodoList readFromFile(){
    String fileName = "todo.txt";
    TodoList tasks = new TodoList();
    try {
      FileInputStream fileInputStream
          = new FileInputStream("todo.txt");
      ObjectInputStream objectInputStream
          = new ObjectInputStream(fileInputStream);
      tasks = (TodoList) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException e){
      System.out.println("Unable to read from the file!");
    } catch (ClassNotFoundException cnf) {
      System.out.println("Unable to read from the file!");
    }
    return tasks;
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
