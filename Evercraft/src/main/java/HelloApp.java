import com.fasterxml.jackson.jr.ob.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HelloApp {
    public static void main(String[] args) throws IOException {
        String response;
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("http://localhost:7654/todos").openStream()).useDelimiter("\\A")) {
            response = s.hasNext() ? s.next() : "";
            Map<String,Object> map = JSON.std.mapFrom(response);
            response = map.get("title").toString();
        }
        System.out.print(response);
    }
}
