import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {
  private static NumberConverter numberConverter;
  @BeforeClass
  public static void before(){
    numberConverter = new NumberConverter();
  }

  @Test
  public void testIfnNumberIs7(){
    String toConvert = "7.00 $";
    String expectedResult = "seven dollars";

    String actualResult = numberConverter.convertNumber(toConvert);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testIfnNumberIsUnder20(){
    String toConvert1 = "3.00 $";
    String toConvert2 = "19.00 $";
    String expectedResult1 = "three dollars";
    String expectedResult2 = "nineteen dollars";

    String actualResult1 = numberConverter.convertNumber(toConvert1);
    String actualResult2 = numberConverter.convertNumber(toConvert2);
    assertEquals(expectedResult1, actualResult1);
    assertEquals(expectedResult2, actualResult2);
  }

  @Test
  public void testNumberIsBetween20And99(){
    String toConvert = "29.00 $";
    String toConvert2 = "40.00 $";

    String expectedResult = "twenty-nine dollars";
    String expectedResult2 = "forty dollars";

    String actualResult = numberConverter.convertNumber(toConvert);
    String actualResult2 = numberConverter.convertNumber(toConvert2);
    assertEquals(expectedResult, actualResult);
    assertEquals(expectedResult2, actualResult2);
  }

  @Test
  public void testNumberIsBetween100And999(){
    String toConvert = "293.00 $";
    String toConvert2 = "100.00 $";
    String toConvert3 = "908.00 $";


    String expectedResult = "two hundred and ninety-three dollars";
    String expectedResult2 = "one hundred dollars";
    String expectedResult3 = "nine hundred and eight dollars";

    String actualResult = numberConverter.convertNumber(toConvert);
    String actualResult2 = numberConverter.convertNumber(toConvert2);
    String actualResult3 = numberConverter.convertNumber(toConvert3);

    assertEquals(expectedResult, actualResult);
    assertEquals(expectedResult2, actualResult2);
    assertEquals(expectedResult3, actualResult3);
  }

  @Test
  public void testIfNumberIsBetween1000And1000000(){
    String toConvert = "1234.00 $";
    String toConvert2 = "200000.00 $";
    String toConvert3 = "10006.00 $";
    String toConvert4 = "132038.00 $";


    String expectedResult = "one thousand two hundred and thirty-four dollars";
    String expectedResult2 = "two hundred thousand dollars";
    String expectedResult3 = "ten thousand and six dollars";
    String expectedResult4 = "one hundred and thirty-two thousand and thirty-eight dollars";

    String actualResult = numberConverter.convertNumber(toConvert);
    String actualResult2 = numberConverter.convertNumber(toConvert2);
    String actualResult3 = numberConverter.convertNumber(toConvert3);
    String actualResult4 = numberConverter.convertNumber(toConvert4);

    assertEquals(expectedResult, actualResult);
    assertEquals(expectedResult2, actualResult2);
    assertEquals(expectedResult3, actualResult3);
    assertEquals(expectedResult4, actualResult4);
  }

  @Test
  public void testWithNullString () {
    String toConvert = null;
    String expectedResult = "No given amount.";

    String actualResult = numberConverter.convertNumber(toConvert);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testIfWeOnlyHaveOneORLessDollar(){
    String toConvert = "1.00 $";
    String expectedResult = "one dollar";

    String actualResult = numberConverter.convertNumber(toConvert);
    assertEquals(expectedResult, actualResult);
  }


}