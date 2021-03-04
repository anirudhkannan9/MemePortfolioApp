package model;

import model.stock.MemeStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import model.stock.BoringStock;

public class BoringStockTest {

    @Test
    public void testChangeBoringStockValueOverTime() {
        //setup
        BoringStock bs = new BoringStock("BRK.A", 100000);
        assertEquals("BRK.A", bs.getStockTicker());
        assertEquals(100000, bs.getCurrentValueDouble());

        //invoke behaviour
        bs.changeValueOverTime(0.8);

        //check outcome
        assertEquals("BRK.A", bs.getStockTicker());
        assertEquals(90000, bs.getCurrentValueDouble());
        assertTrue(bs.getCurrentValueString().contains("90000"));
        assertEquals(-10, bs.getPercentChangeDouble());
        assertTrue(bs.getPercentChangeString().contains("-10"));
    }

    @Test
    public void testRandomDouble() {
        //setup
        BoringStock msft = new BoringStock("MSFT", 100);

        //invoke desired behaviour
        double d = msft.randomDouble();

        //check output
        assertNotNull(d);
        assertTrue(d > 0);
        assertTrue (d < 1);
    }

    @Test
    public void testGetChanceOfBoom() {
        BoringStock msft = new BoringStock("MSFT", 100);

        double d = msft.getChanceOfBoom();

        assertEquals(0.0, d);
    }
}
