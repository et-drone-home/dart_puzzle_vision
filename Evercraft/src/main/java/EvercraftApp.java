import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class EvercraftApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, welcome to Evercraft. Press return to get started.");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
        System.out.println("Attack!");

//        List<String> strings = Files.readAllLines(Paths.get("characters.csv"));
    }
}
