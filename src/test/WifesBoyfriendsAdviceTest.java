import model.stock.MemeStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import model.stock.BoringStock;
import model.portfolio.WifesBoyfriendsAdvice;

public class WifesBoyfriendsAdviceTest {

    @Test
    public void testGetAdvice() {
        //setup


        //invoke desired behaviour
        String str1 = WifesBoyfriendsAdvice.getAdvice();
        String str2 = WifesBoyfriendsAdvice.getAdvice();

        //check output
        assertNotNull(str1);
        assertNotNull(str2);
        assertNotEquals(str1, str2);
        //assertEquals("", str2);
    }
}
