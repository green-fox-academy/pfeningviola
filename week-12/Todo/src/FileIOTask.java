import java.io.*;

public abstract class FileIOTask {

  public static void writeToFile(TodoList tasks) {
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

  public static TodoList readFromFile(){
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
}
