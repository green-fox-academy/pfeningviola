import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GetIndexTest {
  static GetIndex getIndex;
  @BeforeClass
  public static void before(){
    getIndex = new GetIndex();
  }

  @Test
  public void testIfListIsNull(){
    List<Integer> testList = null;
    Integer testValue = 3;
    int expectedResult = -1;

    int actualResult = getIndex.findIndex(testList, testValue);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testIfListIsEmpty () {
    List<Integer> testList = new ArrayList<>(Arrays.asList());
    Integer testValue = 3;
    int expectedResult = -1;

    int actualResult = getIndex.findIndex(testList, testValue);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testIfListHasIntegers(){
    List<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Integer testValue = 3;
    int expectedResult = 2;

    int actualResult = getIndex.findIndex(testList, testValue);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testIfElementIsNotFound () {
    List<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Integer testValue = 6;
    int expectedResult = -1;

    int actualResult = getIndex.findIndex(testList, testValue);
    assertEquals(expectedResult, actualResult);
  }
}