import java.util.List;

public class GetIndex {
//  public int findIndex(List<Integer> testList, Integer testValue) {
//    if ((testList == null) || (testList.size() == 0) || (!testList.contains(testValue))) {
//      return -1;
//    } else {
//      return testList.indexOf(testValue);
//    }
//  }

  public int findIndex(List<Integer> testList, Integer testValue) {
    if (testList == null)
      return -1;
    if (testList.contains(testValue)) {
      return testList.indexOf(testValue);
    } else {
      return -1;
    }
  }
}