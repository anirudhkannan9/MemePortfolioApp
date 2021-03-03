package persistence;

import model.portfolio.Portfolio;
import model.stock.Stock;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//REFERENCE: modelled on JsonReaderTest class in JsonSerializationDemo project
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");

        try {
            Portfolio p = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPortfolioExpectEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPortfolio.json");

        try {
            Portfolio p = reader.read();
            assertEquals(0, p.numStocks());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPortfolio() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPortfolio.json");

        try {
            Portfolio p = reader.read();
            List<Stock> stocks = p.getStocks();
            assertEquals(2, stocks.size());
            checkStock("MemeStock", "PLTR", 100, stocks.get(0));
            checkStock("BoringStock", "BRK.A", 284000, stocks.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
