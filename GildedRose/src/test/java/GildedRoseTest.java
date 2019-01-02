import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void validateUpdateQuality() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/java/GildedRoseUpdate30Days.txt")));
        assertEquals(content, updateQuality());
    }

    public String updateQuality() {
        StringBuilder output = new StringBuilder();
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48)};

        GildedRose app = new GildedRose(items);

        int days = 30;

        for (int i = 0; i < days; i++) {
            output.append("-------- day " + i + " --------\n");
            output.append("name, sellIn, quality\n");
            for (Item item : app.items) {
                output.append(item);
                output.append("\n");
            }
            output.append("\n");
            app.updateQuality();
        }
        return output.toString();
    }
}