public class ArgumentCheck {
  TodoList myList = new TodoList();

  public void checkArguments (String[] arguments) {
    if (arguments.length == 0) {
      printUsage();

    } else if ((arguments[0].equals("-a")) || (arguments[0].equals("-add"))) {
      checkArgumentA(arguments, myList);

    } else if ((arguments[0].equals("-la")) || (arguments[0].equals("-listAll"))) {
      checkArgumentLa(arguments, myList);

    } else if ((arguments[0].equals("-l")) || (arguments[0].equals("-list"))) {
      checkArgumentL(arguments, myList);

    } else if ((arguments[0].equals("-r")) || (arguments[0].equals("-remove"))){
      checkArgumentR(arguments, myList);

    } else if ((arguments[0].equals("-c")) || (arguments[0].equals("-complete"))) {
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
      for (int i = 1; i < args.length; i++) {
        myList.add(args[i]);
      }
      System.out.println(myList);
    }
  }

  public void checkArgumentL(String[] args, TodoList myList) {
    if (args.length == 1) {
      myList.list();
    } else {
      System.out.println("Unsupported argument");
      printUsage();
    }
  }

  public void checkArgumentLa(String[] args, TodoList myList) {
    if (args.length == 1) {
      myList.listAll();
    } else {
      System.out.println("Unsupported argument");
      printUsage();
    }
  }

  public void checkArgumentR(String[] args, TodoList myList) {
    if (args.length == 1) {
      System.out.println("Unable to remove: no index provided");
    } else {
      try {
        for (int i = 1; i < args.length; i++) {
          myList.remove(Integer.parseInt(args[i]));
        }
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
        for (int i = 1; i < args.length; i++) {
          myList.changeStatus(Integer.parseInt(args[i]));
        }
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
        " -l / -list   Lists the undone tasks\n" +
        " -la / -lisAll Lists all the tasks\n" +
        " -a / -add   Adds new tasks\n" +
        " -r / -remove  Removes tasks\n" +
        " -c / -complete  Completes tasks";
    System.out.println(usage);
  }
}
