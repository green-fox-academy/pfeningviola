import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
  private static Animal animal;

  @Before
  public void init() {
    animal = new Animal();
  }

  @Test
  public void testConstructor() {
    assertEquals(50, animal.getHunger());
    assertEquals(50, animal.getThirst());
  }

  @Test
  public void testEatOnce() {
    int expectedResult = 49;

    int result = animal.eat();

    assertEquals(expectedResult, result);
  }

  @Test
  public void testEat100Times() {
    int expectedResult = 0;

    for (int i = 0; i < 100; i++) {
      animal.eat();
    }
    int result = animal.getHunger();

    assertEquals(expectedResult, result);
  }

  @Test
  public void testDrinkOnce() {
    int expectedResult = 49;

    int result = animal.drink();;

    assertEquals(expectedResult, result);
  }

  @Test
  public void testDrink100Times() {
    int expectedResult = 0;

    for (int i = 0; i < 100; i++) {
      animal.drink();
    }
    int result = animal.getThirst();

    assertEquals(expectedResult, result);
  }

  @Test
  public void play() {
    int expectedResultHunger = 51;
    int expectedResultThirst = 51;

    animal.play();
    int resultHunger = animal.getHunger();
    int resultThirst = animal.getThirst();

    assertEquals(expectedResultHunger, resultHunger);
    assertEquals(expectedResultThirst, resultThirst);
  }

  @Test
  public void testGetHunger() {
    int expectedResult = 50;

    int result = animal.getHunger();

    assertEquals(expectedResult, result);
  }

  @Test
  public void testGetThirst() {
    int expectedResult = 50;

    int result = animal.getThirst();

    assertEquals(expectedResult, result);
  }
}
