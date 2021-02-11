
import model.stock.MemeStock;
import model.stock.RandomDouble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemeStockTest {

    @Test
    public void testChangeValueOverTimeMemeStockBoom() {
        //setup - create new MemeStock, randomdouble
        MemeStock tsla = new MemeStock("TSLA", 852);
        double d = 0.09;

        //invoke desired behaviour -- tsla.changeValueOverTime()
        tsla.changeValueOverTime(d);

        //check.
        assertTrue(tsla.getCurrentValueDouble() > tsla.getOldValueDouble());
        assertTrue(tsla.getCurrentValueDouble() == tsla.getOldValueDouble() * 5);
        assertTrue(tsla.getPercentChangeDouble() == 500);
        assertTrue(tsla.getPercentChangeString().contains("500"));

        if (tsla.getCurrentValueDouble() == tsla.getOldValueDouble()*5) {

        } else {
            assertTrue(tsla.getPercentChangeDouble() == 1);
            assertTrue(tsla.getPercentChangeString().contains("1"));

        }
        assertEquals("TSLA", tsla.getStockTicker());
        assertNotNull(tsla.getCurrentValueString());
        assertTrue(tsla.getOldValueString().contains("852"));
    }

    @Test
    public void testChangeValueOverTimeMemeStockNoBoom() {
        //setup - create new MemeStock, randomdouble
        MemeStock tsla = new MemeStock("TSLA", 852);
        double d = 0.4;

        //invoke desired behaviour -- tsla.changeValueOverTime()
        tsla.changeValueOverTime(d);

        //check.
        assertTrue(tsla.getCurrentValueDouble() > tsla.getOldValueDouble());
        assertTrue(tsla.getCurrentValueDouble() == tsla.getOldValueDouble() * 1.01);
        assertTrue(tsla.getPercentChangeDouble() == 1);
        assertTrue(tsla.getPercentChangeString().contains("1"));
        assertEquals("TSLA", tsla.getStockTicker());
        assertNotNull(tsla.getCurrentValueString());
        assertTrue(tsla.getOldValueString().contains("852"));
    }

    //testing randomDouble
    @Test
    public void testRandomDouble() {
        //setup
        MemeStock tsla = new MemeStock("TSLA", 852);

        //invoke desired behaviour
        double d = tsla.randomDouble();

        //check output
        assertNotNull(d);
        assertTrue(d > 0);
        assertTrue (d < 1);
    }


}
