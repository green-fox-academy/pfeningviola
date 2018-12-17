import java.io.*;
import java.util.ArrayList;

public class TodoList implements Serializable {
  private ArrayList<Todo> todoList;

  public TodoList() {
    //if (new File("todo.txt").length() > 0) {
      //this.todoList = readFromFile().getTodoList();
    //} else {
      this.todoList = new ArrayList<>();
    //}
  }

  public void add(String todo) {
    if (new File("todo.txt").length() > 0) {
      this.todoList = readFromFile().getTodoList();
    }
    this.todoList.add(new Todo(todo));
    writeToFile(this);
  }

  public void list(){
    if (new File("todo.txt").length() > 0) {
      this.todoList = readFromFile().getTodoList();
      System.out.println(this.toString());
    } else {
      System.out.println("No todos for today! :)");
    }
  }

  public void remove (int number) {
    int indexToRemove = number - 1;
    this.todoList = readFromFile().getTodoList();
    if (todoList.size() >= number) {
      this.todoList.remove(indexToRemove);
      writeToFile(this);
    } else {
      System.out.println("Unable to remove: index is out of bound");
    }
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
          = new FileInputStream(fileName);
      ObjectInputStream objectInputStream
          = new ObjectInputStream(fileInputStream);
      tasks = (TodoList) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException e){
      System.out.println("Unable to read from the file!");
    } catch (ClassNotFoundException cnf) {
      System.out.println("The file has a problem");
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
