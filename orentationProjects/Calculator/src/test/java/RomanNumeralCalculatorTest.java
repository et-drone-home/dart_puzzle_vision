import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralCalculatorTest {

  @Test
  public void onePlusOneIsTwo() {
    RomanNumeralCalculator calculator = new RomanNumeralCalculator();

    String actualResult = calculator.add("I", "I");
    String expectedResult = "II";

    assertEquals(expectedResult, actualResult);
  }
}
