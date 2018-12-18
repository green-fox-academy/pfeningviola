public class ArgumentCheck {

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
}
