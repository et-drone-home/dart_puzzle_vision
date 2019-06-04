import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JsonParserTest {
    @Test
    public void jsonParsing() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("{\"gesture\":\"rock\"}".getBytes());
        String opponentGesture = JsonParser.getGesture(inputStream);
        assertEquals("rock", opponentGesture);
    }

}
