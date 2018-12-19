import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

  public static void writeToFile2(TodoList tasks) {
    Path filePath = Paths.get("./todo.txt");
    List<String> newList = new ArrayList<>();
    for (Todo task : tasks.getTodoList()) {
      newList.add(task.getDescription() + ";" + task.isCompleted());
    }
    try {
      Files.write(filePath, newList);
    } catch (IOException e){
      System.out.println("Unable to write to the file.");
    }
  }

  public static TodoList readFromFile2() {
    Path filePath = Paths.get("./todo.txt");
    List<String> lines = new ArrayList<>();
    TodoList myList = new TodoList();
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Unable to read from the file.");
    }

    for (String line : lines) {
      String[] splittedLine = line.split(";");
      if (splittedLine.length > 1) {
        myList.getTodoList().add(new Todo(splittedLine[0], Boolean.parseBoolean(splittedLine[1])));
      }
    }
    return myList;
  }

}
