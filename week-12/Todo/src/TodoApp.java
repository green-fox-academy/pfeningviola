public class TodoApp {
  public static void main(String[] args) {
    TodoList myList = new TodoList();
    if (args.length == 0) {
      printMessageIfArgsEmpty();
    }

    if (args[0].equals("-a")){
      myList.add(args[1]);
      System.out.println(myList);
    }

    if (args[0].equals("-l")) {
      myList.list();
    }
  }

  public static void printMessageIfArgsEmpty() {
    String usage = "Command Line Todo application\n" +
        "=============================\n" +
        "\n" +
        "Command line arguments:\n" +
        " -l   Lists all the tasks\n" +
        " -a   Adds a new task\n" +
        " -r   Removes a task\n" +
        " -c   Completes a task";
    System.out.println(usage);
  }
}
