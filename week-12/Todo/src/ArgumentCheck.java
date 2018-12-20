public class ArgumentCheck {
  TodoList myList = new TodoList();

  public void checkArguments (String[] arguments) {
    if (arguments.length == 0) {
      printUsage();

    } else if (arguments.length > 2) {
      System.out.println("The given argument is not valid.");
      printUsage();

    } else if (arguments[0].equals("-a")) {
      checkArgumentA(arguments, myList);

    } else if (arguments[0].equals("-l")) {
      checkArgumentL(arguments, myList);

    } else if (arguments[0].equals("-r")) {
      checkArgumentR(arguments, myList);

    } else if (arguments[0].equals("-c")) {
      checkArgumentC(arguments, myList);

    } else {
      System.out.println("Unsupported argument");
      printUsage();
    }
  }

  public void checkArgumentA(String[] args, TodoList myList) {
    if (args.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else {
      myList.add(args[1]);
      System.out.println(myList);
    }
  }

  public void checkArgumentL(String[] args, TodoList myList) {
    if (args.length == 1) {
      myList.list();
    } else {
      System.out.println("Unsupported argument");
    }
  }

  public void checkArgumentR(String[] args, TodoList myList) {
    if (args.length == 1) {
      System.out.println("Unable to remove: no index provided");
    } else {
      try {
        myList.remove(Integer.parseInt(args[1]));
        System.out.println(myList);
      } catch (IndexOutOfBoundsException out) {
        System.out.println("Unable to remove: index is out of bound");
      } catch (NumberFormatException letters) {
        System.out.println("Unable to remove: index is not a number");
      }
    }
  }

  public void checkArgumentC(String[] args, TodoList myList) {
      if (args.length == 1) {
      System.out.println("Unable to check: no index provided");
    } else {
      try {
        myList.changeStatus(Integer.parseInt(args[1]));
        System.out.println(myList);
      } catch (IndexOutOfBoundsException out) {
        System.out.println("Unable to check: index is out of bound");
      } catch (NumberFormatException letters) {
        System.out.println("Unable to remove: index is not a number");
      }
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
