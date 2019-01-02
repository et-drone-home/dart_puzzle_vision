import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanToArabicConverterTest {

  @Test
  public void canConvertXVItoSixteen() throws Exception {
    RomanToArabicConverter converter = new RomanToArabicConverter();

    assertEquals(16, converter.convertToInteger("XVI"));
  }

}
