


import model.stock.MemeStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import model.stock.BoringStock;

//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(70000, bs.getCurrentValueDouble());
        assertTrue(bs.getCurrentValueString().contains("70000"));
        assertEquals(-30, bs.getPercentChangeDouble());
        assertTrue(bs.getPercentChangeString().contains("-30"));
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
}
