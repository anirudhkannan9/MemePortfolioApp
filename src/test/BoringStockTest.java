


import org.junit.jupiter.api.Test;

import model.Stock.BoringStock;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoringStockTest {

    @Test
    public void testChangeBoringStockValueOverTime() {
        //setup
        BoringStock bs = new BoringStock("BRK.A", 100000);
        assertEquals("BRK.A", bs.getStockTicker());
        assertEquals(100000, bs.getCurrentValueDouble());

        //invoke behaviour
        bs.changeValueOverTime();

        //check outcome
        assertEquals("BRK.A", bs.getStockTicker());
        assertEquals(70000, bs.getCurrentValueDouble());
        assertTrue(bs.getCurrentValueString().contains("70000"));
        assertEquals(-30, bs.getPercentChangeDouble());
        assertTrue(bs.getPercentChangeString().contains("-30"));
    }
}
