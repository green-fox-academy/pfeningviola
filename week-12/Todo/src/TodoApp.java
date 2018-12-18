public class TodoApp {
  public static void main(String[] args) {
    TodoList myList = new TodoList();
    ArgumentCheck checker = new ArgumentCheck();
    if (args.length == 0) {
      printUsage();

    } else if (args.length > 2) {
      System.out.println("The given argument is not valid.");
      printUsage();

    } else if (args[0].equals("-a")){
        checker.checkArgumentA(args, myList);

    } else if (args[0].equals("-l")) {
      checker.checkArgumentL(args, myList);

    } else if (args[0].equals("-r")) {
      checker.checkArgumentR(args, myList);

    } else if (args[0].equals("-c")) {
      checker.checkArgumentC(args, myList);

    } else {
      System.out.println("Unsupported argument");
      printUsage();
    }
  }

  public static void printUsage() {
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
