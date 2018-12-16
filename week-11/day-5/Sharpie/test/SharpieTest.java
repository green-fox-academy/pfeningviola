import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SharpieTest {
  private static Sharpie sharpie;

  @BeforeClass
  public static void init() {
    sharpie = new Sharpie("red", 1.5f);
  }

  @Test
  public void testUseOnce() {
    float expectedResult = 99;

    sharpie.use();
    float result = sharpie.getInkAmount();

    assertEquals(expectedResult, result, expectedResult - result);
  }

  @Test
  public void testUse105Times() {
    float expectedResult = 0;

    for (int i = 0; i < 105; i++){
      sharpie.use();
    }
    float result = sharpie.getInkAmount();

    assertEquals(expectedResult, result, expectedResult - result);
  }

  @Test
  public void testGetInkAmount() {
    float expectedResult = 100;

    float result = sharpie.getInkAmount();

    assertEquals(expectedResult, result, expectedResult - result);
  }
}
