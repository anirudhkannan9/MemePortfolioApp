package persistence;

import model.stock.Stock;
import model.stock.MemeStock;
import model.stock.BoringStock;
import model.portfolio.Portfolio;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Portfolio p = new Portfolio();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPortfolio() {
        try {
            Portfolio p = new Portfolio();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPortfolio.json");
            writer.open();
            writer.write(p);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPortfolio.json");
            p = reader.read();
            assertEquals(0, p.numStocks());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPortfolio() {
        try {
            Portfolio p = new Portfolio();
            p.addStock(new MemeStock("TSLA", 852));
            p.addStock(new BoringStock("BRNG", 100.0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPortfolio.json");
            writer.open();
            writer.write(p);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPortfolio.json");
            p = reader.read();
            List<Stock> stocks = p.getStocks();
            assertEquals(2, stocks.size());
            checkStock("MemeStock", "TSLA", 852, stocks.get(0));
            checkStock("BoringStock", "BRNG", 100.0, stocks.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
