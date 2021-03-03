package persistence;

import model.stock.BoringStock;
import model.stock.MemeStock;
import model.stock.Stock;

import static org.junit.jupiter.api.Assertions.*;

//REFERENCE: modelled on JsonReaderTest class in JsonSerializationDemo project
public class JsonTest {
    protected void checkStock(String type, String tkr, double val, Stock stock) {
        if (stock.getType().equals("BoringStock")) {
            //check equality of arguments + type should be BoringStock
            assertEquals("BoringStock", type);
            assertTrue(stock instanceof BoringStock);
            assertEquals(tkr, stock.getStockTicker());
            assertEquals(val, stock.getCurrentValueDouble());

        } else {
            //check equality of arguments + type should be MemeStock
            assertEquals("MemeStock", type);
            assertTrue(stock instanceof MemeStock);
            assertEquals(tkr, stock.getStockTicker());
            assertEquals(val, stock.getCurrentValueDouble());

        }
    }
}
