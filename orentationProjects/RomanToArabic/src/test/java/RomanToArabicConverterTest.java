import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class RomanToArabicConverterTest {

  private RomanToArabicConverter converter = new RomanToArabicConverter();

  @Test
  public void canConvertXVItoSixteen() {
    assertEquals(16, converter.convertToInteger("XVI"));
  }

  @Test
  public void canConvertItoOne() {
    assertEquals(1, converter.convertToInteger("I"));
  }

  @Test
  public void canConvertIItoTwo() {
    assertEquals(2, converter.convertToInteger("II"));
  }

  @Test
  public void canConvertIIItoThree() {
    assertEquals(3, converter.convertToInteger("III"));
  }

  @Test
  public void canConvertVtoFive() {
    assertEquals(5, converter.convertToInteger("V"));
  }

  @Test
  public void canConvertXtoTen() {
    assertEquals(10, converter.convertToInteger("X"));
  }

  @Test
  public void canConvertXXtoTwenty() {
    assertEquals(20, converter.convertToInteger("XX"));
  }

  @Test
  public void canConvertIXtoNine() {
    assertEquals(9, converter.convertToInteger("IX"));
  }

  @Test
  public void canConvertLtoFifty() {
    assertEquals(50, converter.convertToInteger("L"));
  }

  @Test
  public void canConvertXLtoForty() {
    assertEquals(40, converter.convertToInteger("XL"));
  }

  @Test
  public void canConvertCtoOneHundred() {
    assertEquals(100, converter.convertToInteger("C"));
  }

  @Test
  public void canConvertXCtoNinety() {
    assertEquals(90, converter.convertToInteger("XC"));
  }

  @Test
  public void canConvertDtoFiveHundred() {
    assertEquals(500, converter.convertToInteger("D"));
  }

  @Test
  public void canConvertIXDtoFourHundred() {
    assertEquals(400, converter.convertToInteger("CD"));
  }

  @Test
  public void canConvertMtoOneThousand() {
    assertEquals(1000, converter.convertToInteger("M"));
  }

  @Test
  public void canConvertCMtoNineHundred() {
    assertEquals(900, converter.convertToInteger("CM"));
  }

}
