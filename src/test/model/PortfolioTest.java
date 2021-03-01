package model;

import model.portfolio.Portfolio;
import model.stock.BoringStock;
import model.stock.MemeStock;
import model.stock.Stock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    Portfolio portfolio;
    MemeStock ms;
    BoringStock bs;


//    @Before
//    public void runBefore() {
//        portfolio = new Portfolio();
//        ms = new MemeStock("TSLA", 852);
//        bs = new BoringStock("MSFT", 242);
//    }

    @Test
    public void testaddOneMemeStock() {
        //setup
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);

        //invoke desired behaviour
        portfolio.addStock(tsla);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.size() == 1);
        assertTrue(output.contains(tsla));
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 852);
    }

    @Test
    public void testaddOneBoringStock() {
        //setup
        portfolio = new Portfolio();
        BoringStock x = new BoringStock("X", 10);

        //invoke desired behaviour
        portfolio.addStock(x);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.size() == 1);
        assertTrue(output.contains(x));
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 10);

    }
//
    @Test
    public void testaddManyMemeStocks() {
        //setup
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock bb = new MemeStock("BB", 13);

        //invoke desired behaviour
        portfolio.addStock(tsla);
        portfolio.addStock(bb);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.contains(tsla));
        assertTrue(output.contains(bb));
        assertTrue(output.size() == 2);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 865);
    }

    //
    @Test
    public void testaddManyBoringStocks() {
        //setup
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("MSFT", 100);
        BoringStock goog = new BoringStock("BB", 10);
        BoringStock xyz = new BoringStock("XYZ", 1);

        //invoke desired behaviour
        portfolio.addStock(msft);
        portfolio.addStock(goog);
        portfolio.addStock(xyz);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.contains(msft));
        assertTrue(output.contains(goog));
        assertTrue(output.contains(xyz));
        assertTrue(output.size() == 3);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 111);

    }

    //
    @Test
    public void testaddMemeAndBoringStocks() {
        //setup
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        BoringStock bs = new BoringStock("bs", 10);

        //invoke desired behaviour
        portfolio.addStock(tsla);
        portfolio.addStock(bs);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.size() == 2);
        assertTrue(output.contains(tsla));
        assertTrue(output.contains(bs));
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 862);

    }

    //
    @Test
    public void testaddDuplicateMemeStock() {
        //setup
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock tslb = new MemeStock("TSLA", 852);

        //invoke desired behaviour
        portfolio.addStock(tsla);
        portfolio.addStock(tslb);

        //check output: portfolio contains stock, portfolio value updated to include value of stock
        List output = portfolio.getStocks();
        assertTrue(output.contains(tsla));
        assertFalse(output.contains(tslb));
        assertTrue(output.size() == 1);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 852);

    }

    //
    @Test
    public void testaddDuplicateBoringStock() {
        //setup
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("msft", 1);
        BoringStock msfu = new BoringStock("msft", 3);

        //invoke desired behaviour
        portfolio.addStock(msft);
        portfolio.addStock(msfu);

        //check output: portfolio contains 1 BS, duplicate not added
        List output = portfolio.getStocks();
        assertTrue(output.contains(msft));
        assertFalse(output.contains(msfu));
        assertTrue(output.size() == 1);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 1);
    }

    //
    @Test
    public void testaddMemeStockSameTickerAsBoringStock() {
        //setup
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("msft", 1);
        MemeStock msfu = new MemeStock("msft", 3);

        //invoke desired behaviour
        portfolio.addStock(msft);
        portfolio.addStock(msfu);

        //check output: portfolio contains 1 BS, 0 MS, duplicate not added
        List output = portfolio.getStocks();
        assertTrue(output.contains(msft));
        assertFalse(output.contains(msfu));
        assertTrue(output.size() == 1);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 1);

    }

    //
    @Test
    public void testaddBoringStockSameTickerAsMemeStock() {
        //setup
        portfolio = new Portfolio();
        MemeStock msft = new MemeStock("msft", 3);
        BoringStock msfu = new BoringStock("msft", 1);

        //invoke desired behaviour
        portfolio.addStock(msft);
        portfolio.addStock(msfu);

        //check output: portfolio contains 1 MS, 0 BS, duplicate BS not added
        List output = portfolio.getStocks();
        assertTrue(output.contains(msft));
        assertFalse(output.contains(msfu));
        assertTrue(output.size() == 1);
        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 3);
    }


    @Test
    public void testSellOneMemeStock() {
        //setup - create MS, portfolio, add MS to port
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio = new Portfolio();
        portfolio.addStock(tsla);

        //invoke desired behaviour
        String sellOutput = portfolio.sellStock(tsla);

        //check output - String that says Stock X has been sold, you have $X in hand
        assertTrue(sellOutput != null);
        assertTrue(sellOutput.contains("TSLA"));
        assertTrue(sellOutput.contains("852"));
        assertEquals("SOLD: TSLA for $852.0", sellOutput);

    }

    @Test
    public void testSellOneBoringStock() {
        //setup - create BS, portfolio, add BS to port
        BoringStock msft = new BoringStock("MSFT", 100);
        portfolio = new Portfolio();
        portfolio.addStock(msft);

        //invoke desired behaviour
        String sellOutput = portfolio.sellStock(msft);

        //check output - String that says Stock X has been sold, you have $X in hand
        assertTrue(sellOutput != null);
        assertTrue(sellOutput.contains("MSFT"));
        assertTrue(sellOutput.contains("100"));
        assertEquals("SOLD: MSFT for $100.0", sellOutput);

    }

    @Test
    public void testHoldTheLineOneMemeStock() {
        //setup - create portfolio, 1x MS, add MS to portfolio
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(tsla);

        //invoke desired behaviour - hold the line - and assign to output
        String holdTheLine = portfolio.holdTheLine();

        //check output
        assertNotNull(holdTheLine);
        assertTrue(holdTheLine.contains("HOLD THE LINE!!!! Diamond hands babyyyy "));
        assertTrue(holdTheLine.contains("Keeping you in: "));
        assertTrue(holdTheLine.contains("TSLA @ $852"));
    }


    @Test
    public void testHoldTheLineManyMemeStocks() {
        //setup - create portfolio, 2x MS, add MSes to portfolio
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock gme = new MemeStock("GME", 67);
        portfolio.addStock(tsla);
        portfolio.addStock(gme);

        //invoke desired behaviour - hold the line - and assign to output
        String holdTheLine = portfolio.holdTheLine();

        //check output
        assertNotNull(holdTheLine);
        assertTrue(holdTheLine.contains("HOLD THE LINE!!!! Diamond hands babyyyy "));
        assertTrue(holdTheLine.contains("Keeping you in: "));
        assertTrue(holdTheLine.contains("TSLA @ $852"));
        assertTrue(holdTheLine.contains("GME @ $67"));

    }

    //
    @Test
    public void testHoldTheLineOneBoringStock() {
        //setup - create portfolio, 1x BS, add BS to portfolio
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("MSFT", 100);
        portfolio.addStock(msft);

        //invoke desired behaviour - hold the line - and assign to output
        String holdTheLine = portfolio.holdTheLine();

        //check output
        assertNotNull(holdTheLine);
        assertTrue(holdTheLine.contains("HOLD THE LINE!!!! Diamond hands babyyyy "));
        assertTrue(holdTheLine.contains("Keeping you in: "));
        assertTrue(holdTheLine.contains("MSFT @ $100"));

    }

    //
    @Test
    public void testHoldTheLineManyBoringStocks() {
        //setup - create portfolio, 2x BS, add BSes to portfolio
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("MSFT", 100);
        BoringStock goog = new BoringStock("GOOG", 200);
        portfolio.addStock(msft);
        portfolio.addStock(goog);

        //invoke desired behaviour - hold the line - and assign to output
        String holdTheLine = portfolio.holdTheLine();

        //check output
        assertNotNull(holdTheLine);
        assertTrue(holdTheLine.contains("HOLD THE LINE!!!! Diamond hands babyyyy "));
        assertTrue(holdTheLine.contains("Keeping you in: "));
        assertTrue(holdTheLine.contains("MSFT @ $100"));
        assertTrue(holdTheLine.contains("GOOG @ $200"));

    }

    @Test
    public void testHoldTheLineBothMemeAndBoringStocks() {
        //setup - create portfolio, 2x MS, 2xBS, add all to portfolio
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock gme = new MemeStock("GME", 67);
        BoringStock msft = new BoringStock("MSFT", 100);
        BoringStock goog = new BoringStock("GOOG", 200);
        portfolio.addStock(msft);
        portfolio.addStock(goog);
        portfolio.addStock(tsla);
        portfolio.addStock(gme);

        //invoke desired behaviour - hold the line - and assign to output
        String holdTheLine = portfolio.holdTheLine();

        //check output
        assertNotNull(holdTheLine);
        assertTrue(holdTheLine.contains("HOLD THE LINE!!!! Diamond hands babyyyy "));
        assertTrue(holdTheLine.contains("Keeping you in: "));
        assertTrue(holdTheLine.contains("TSLA @ $852"));
        assertTrue(holdTheLine.contains("GME @ $67"));
        assertTrue(holdTheLine.contains("MSFT @ $100"));
        assertTrue(holdTheLine.contains("GOOG @ $200"));

    }

    @Test
    public void testliquidateOneMemeStock() {
        //setup - create MS, create portfolio, add MS to portfolio
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio = new Portfolio();
        portfolio.addStock(tsla);

        //invoke desired behaviour
        String liquidateOutput = portfolio.liquidateGetTendies();
        List<Stock> portfolioList = portfolio.getStocks();

        //check output - String that lists all (1) stocks that've been sold
        //and presents cash value of entire portfolio
        assertNotNull(liquidateOutput);
        assertTrue(liquidateOutput.contains("Portfolio empty. Portfolio value: $0"));
        assertEquals(0, portfolioList.size());
        assertFalse(portfolioList.contains(tsla));
        assertTrue(liquidateOutput.contains("Cash on hand: $852.0"));
        assertTrue(liquidateOutput.contains(" Go get them tendies baby. You can afford: "));
    }

    //
    @Test
    public void testliquidateOneBoringStock() {
        //setup - create BS, create portfolio, add BS to portfolio
        BoringStock msft = new BoringStock("MSFT", 100);
        portfolio = new Portfolio();
        portfolio.addStock(msft);

        //invoke desired behaviour
        String liquidateOutput = portfolio.liquidateGetTendies();
        List<Stock> portfolioList = portfolio.getStocks();

        //check output - String that lists all (1) stocks that've been sold
        //and presents cash value of entire portfolio
        assertNotNull(liquidateOutput);
        assertTrue(liquidateOutput.contains("Portfolio empty. Portfolio value: $0"));
        assertEquals(0, portfolioList.size());
        assertFalse(portfolioList.contains(msft));
        assertTrue(liquidateOutput.contains("Cash on hand: $100.0"));
        assertTrue(liquidateOutput.contains(" Go get them tendies baby. You can afford: "));

    }

    @Test
    public void testliquidateManyMemeStocks() {
        //setup - create 2xMS, create portfolio, add MSes to portfolio
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock gme = new MemeStock("GME", 67);
        portfolio = new Portfolio();
        portfolio.addStock(tsla);
        portfolio.addStock(gme);

        //invoke desired behaviour
        String liquidateOutput = portfolio.liquidateGetTendies();
        List<Stock> portfolioList = portfolio.getStocks();

        //check output - String that lists all (1) stocks that've been sold
        //and presents cash value of entire portfolio
        assertNotNull(liquidateOutput);
        assertTrue(liquidateOutput.contains("Portfolio empty. Portfolio value: $0"));
        assertEquals(0, portfolioList.size());
        assertFalse(portfolioList.contains(tsla));
        assertFalse(portfolioList.contains(gme));
        assertTrue(liquidateOutput.contains("TSLA"));
        assertTrue(liquidateOutput.contains("GME"));
        assertTrue(liquidateOutput.contains("Cash on hand: $919.0"));
        assertTrue(liquidateOutput.contains(" Go get them tendies baby. You can afford: "));

    }


    @Test
    public void testliquidateManyBoringStocks() {
        //setup - create 3xBS, create portfolio, add BSes to portfolio
        BoringStock msft = new BoringStock("MSFT", 100);
        BoringStock goog = new BoringStock("GME", 200);
        BoringStock brka = new BoringStock("BRK.A", 300);
        portfolio = new Portfolio();
        portfolio.addStock(msft);
        portfolio.addStock(goog);
        portfolio.addStock(brka);

        //invoke desired behaviour
        String liquidateOutput = portfolio.liquidateGetTendies();
        List<Stock> portfolioList = portfolio.getStocks();

        //check output - String that lists all (1) stocks that've been sold
        //and presents cash value of entire portfolio
        assertNotNull(liquidateOutput);
        assertTrue(liquidateOutput.contains("Portfolio empty. Portfolio value: $0"));
        assertEquals(0, portfolioList.size());
        assertFalse(portfolioList.contains(msft));
        assertFalse(portfolioList.contains(goog));
        assertFalse(portfolioList.contains(brka));
        assertTrue(liquidateOutput.contains("MSFT"));
        assertTrue(liquidateOutput.contains("GME"));
        assertTrue(liquidateOutput.contains("BRK.A"));
        assertTrue(liquidateOutput.contains("Cash on hand: $600.0"));
        assertTrue(liquidateOutput.contains(" Go get them tendies baby. You can afford: "));

    }

    //
    @Test
    public void testliquidateBothMemeAndBoringStocks() {
        //setup - create 2xBS, 2xMS, create portfolio, add all to portfolio
        BoringStock msft = new BoringStock("MSFT", 100);
        BoringStock goog = new BoringStock("GOOG", 200);
        MemeStock tsla = new MemeStock("TSLA", 852);
        MemeStock gme = new MemeStock("GME", 67);
        portfolio = new Portfolio();
        portfolio.addStock(msft);
        portfolio.addStock(goog);
        portfolio.addStock(tsla);
        portfolio.addStock(gme);

        //invoke desired behaviour
        String liquidateOutput = portfolio.liquidateGetTendies();
        List<Stock> portfolioList = portfolio.getStocks();

        //check output - String that lists all (1) stocks that've been sold
        //and presents cash value of entire portfolio
        assertNotNull(liquidateOutput);
        assertTrue(liquidateOutput.contains("Portfolio empty. Portfolio value: $0"));
        assertEquals(0, portfolioList.size());
        assertFalse(portfolioList.contains(msft));
        assertFalse(portfolioList.contains(goog));
        assertFalse(portfolioList.contains(tsla));
        assertFalse(portfolioList.contains(gme));
        assertTrue(liquidateOutput.contains("MSFT"));
        assertTrue(liquidateOutput.contains("GOOG"));
        assertTrue(liquidateOutput.contains("TSLA"));
        assertTrue(liquidateOutput.contains("GME"));
        assertTrue(liquidateOutput.contains("Cash on hand: $1219.0"));
        assertTrue(liquidateOutput.contains(" Go get them tendies baby. You can afford: "));

    }

    @Test
    public void changePortfolioValueOverTimeOneMemeStock() {
        //setup - create 1xMS, portfolio, add MS to portfolio
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(tsla);

        //invoke desired behaviour - portfolio.changePortfolioValueOverTime()
        String output = portfolio.changePortfolioValueOverTime();
        List<Stock> portList = portfolio.getStocks();

        //check output - still contains same stock etc., but value of stock & portfolio are higher - MS
        //also check that right message printed
        assertTrue(portList.size() == 1);
        assertTrue(portList.contains(tsla));

        Stock tslaAfterChangePortValueOverTime = portList.get(0);
        assertTrue(tslaAfterChangePortValueOverTime.getCurrentValueDouble() > 852);
        assertTrue(tslaAfterChangePortValueOverTime.getPercentChangeDouble() > 0);

        assertTrue(portfolio.getCurrentPortfolioValueDouble() > 852);
        assertTrue(portfolio.getPercentChangeDouble() > 0);

        assertTrue(output.contains("Your portfolio used to be worth: $852"));
        assertTrue(output.contains("Your portfolio has changed"));
        assertTrue(output.contains("%"));
        assertTrue(output.contains("Your portfolio is now worth: $"));


    }

    @Test
    public void changePortfolioValueOverTimeOneBoringStock() {
        //setup - create 1xBS, portfolio, add BS to portfolio
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("MSFT", 100);
        portfolio.addStock(msft);

        //invoke desired behaviour - portfolio.changePortfolioValueOverTime()
        String output = portfolio.changePortfolioValueOverTime();
        List<Stock> portList = portfolio.getStocks();

        //check output - still contains same stock etc., but value of stock/portfolio are different (lower - BS)
        assertTrue(portList.size() == 1);
        assertTrue(portList.contains(msft));

        Stock msftAfterChangePortValueOverTime = portList.get(0);
        assertTrue(msftAfterChangePortValueOverTime.getCurrentValueDouble() == 90);
        assertTrue(msftAfterChangePortValueOverTime.getPercentChangeDouble() == -10);

        assertTrue(portfolio.getCurrentPortfolioValueDouble() == 90);
        assertTrue(portfolio.getPercentChangeDouble() == -10);

        assertTrue(output.contains("Your portfolio used to be worth: $100"));
        assertTrue(output.contains("Your portfolio has changed"));
        assertTrue(output.contains("%"));
        assertTrue(output.contains("Your portfolio is now worth: $"));

    }

    @Test
    public void changePortfolioValueOverTimeManyMemeAndBoringStocks() {
        //setup - create 2xBS, 2xMS, portfolio, add stocks to portfolio
        portfolio = new Portfolio();
        BoringStock msft = new BoringStock("MSFT", 100);
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(msft);
        portfolio.addStock(tsla);

        //invoke desired behaviour - portfolio.changePortfolioValueOverTime()
        String output = portfolio.changePortfolioValueOverTime();
        List<Stock> portList = portfolio.getStocks();

        //check output - still contains same stock etc., but value of stock/portfolio are different
        assertTrue(portList.size() == 2);
        assertTrue(portList.contains(msft));
        assertTrue(portList.contains(tsla));

        Stock msftAfterChangePortValueOverTime = portList.get(0);
        assertTrue(msftAfterChangePortValueOverTime.getCurrentValueDouble() == 90);
        assertTrue(msftAfterChangePortValueOverTime.getPercentChangeDouble() == -10);
        Stock tslaAfterChangePortValueOverTime = portList.get(1);
        assertTrue(tslaAfterChangePortValueOverTime.getCurrentValueDouble() > 852);
        assertTrue(tslaAfterChangePortValueOverTime.getPercentChangeDouble() > 0);

        assertTrue(portfolio.getCurrentPortfolioValueDouble() != 0);
        assertTrue(portfolio.getPercentChangeDouble() != 0);
        assertTrue(portfolio.getOldPortfolioValueDouble() == 952.0);

        assertTrue(output.contains("Your portfolio used to be worth: $952"));
        assertTrue(output.contains("Your portfolio has changed"));
        assertTrue(output.contains("%"));
        assertTrue(output.contains("Your portfolio is now worth: $"));

    }

    @Test
    public void testConsultWifesBoyfriendNoStocks() {
        //setup - create portfolio
        portfolio = new Portfolio();

        //invoke desired behaviour
        String advice = portfolio.consultWifesBoyfriend();

        //check output
        assertNotNull(advice);

    }

    @Test
    public void testConsultWifesBoyfriendSomeStocks() {
        //setup - create portfolio, create Stocks, add to portfolio
        portfolio = new Portfolio();
        Stock msft = new BoringStock("MSFT", 100);
        Stock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(msft);
        portfolio.addStock(tsla);

        //invoke desired behaviour
        String advice = portfolio.consultWifesBoyfriend();

        //check output
        assertNotNull(advice);


    }

    @Test
    public void testViewLossPornOneStockNoChange() {
        //setup - create Portfolio, 1x Stock, add to Portfolio
        portfolio = new Portfolio();
        Stock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(tsla);

        //invoke desired behaviour, assign to variable
        String summary = portfolio.viewLossPorn();

        //check output
        assertNotNull(summary);
        assertTrue(summary.contains("TSLA"));
        assertTrue(summary.contains("852"));
        assertTrue(summary.contains("0"));
        assertTrue(summary.contains("TOTAL CHANGE"));
        assertTrue(summary.contains("PERCENT CHANGE"));

    }

    @Test
    public void testViewLossPornManyStocksNoChange() {
        //setup - create Portfolio, 1x Stock, add to Portfolio
        portfolio = new Portfolio();
        Stock tsla = new MemeStock("TSLA", 852);
        Stock msft = new BoringStock("MSFT", 100);
        portfolio.addStock(tsla);
        portfolio.addStock(msft);

        //invoke desired behaviour, assign to variable
        String summary = portfolio.viewLossPorn();

        //check output
        assertNotNull(summary);
        assertTrue(summary.contains("TSLA"));
        assertTrue(summary.contains("852"));
        assertTrue(summary.contains("MSFT"));
        assertTrue(summary.contains("100"));
        assertTrue(summary.contains("0"));
        assertTrue(summary.contains("TOTAL CHANGE"));
        assertTrue(summary.contains("PERCENT CHANGE"));
    }

    @Test
    public void testViewLossPornOneStockChange() {
        //setup - create Portfolio, 1x Stock, add to Portfolio
        portfolio = new Portfolio();
        Stock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(tsla);

        //desired behaviour: viewLossPorn, changeValueOfPortfolio, viewLossPorn
        //invoke desired behaviour, assign to variable
        String summary1 = portfolio.viewLossPorn();
        portfolio.changePortfolioValueOverTime();
        String summary2 = portfolio.viewLossPorn();

        //check output
        assertNotNull(summary1);
        assertNotNull(summary2);
        assertTrue(summary1.contains("TSLA"));
        assertTrue(summary2.contains("TSLA"));
        assertTrue(summary1.contains("0"));
        assertTrue(summary1.contains("852"));
        assertFalse(summary2.contains("852."));
        assertTrue(summary1.contains("0%"));
        assertFalse(summary2.contains(" 0%"));


    }

    @Test
    public void testViewLossPornManyStocksChange() {
        //setup - create Portfolio, 2x Stocks, add to Portfolio
        portfolio = new Portfolio();
        Stock tsla = new MemeStock("TSLA", 852);
        Stock msft = new BoringStock("MSFT", 100);
        portfolio.addStock(tsla);
        portfolio.addStock(msft);

        //desired behaviour: viewLossPorn, changeValueOfPortfolio, viewLossPorn
        //invoke desired behaviour, assign to variable
        String summary1 = portfolio.viewLossPorn();
        portfolio.changePortfolioValueOverTime();
        String summary2 = portfolio.viewLossPorn();

        //check output
        assertNotNull(summary1);
        assertNotNull(summary2);
        assertTrue(summary1.contains("TSLA"));
        assertTrue(summary2.contains("TSLA"));
        assertTrue(summary2.contains("MSFT"));
        assertTrue(summary2.contains("MSFT"));
        assertTrue(summary1.contains("0%"));
        assertTrue(summary1.contains("952"));
        assertFalse(summary2.contains("952."));
        assertFalse(summary2.contains(" 0%"));


    }

    //testing get
    @Test
    public void getPercentChangeDoubleOldPortfolioValueIsZero() {
        //setup - create new Portfolio
        portfolio = new Portfolio();

        //invoke desired behaviour - getPercentChangeDouble
        double pct  = portfolio.getPercentChangeDouble();

        //check output
        assertNotNull(pct);
        assertTrue(pct == 0);
    }

    @Test
    public void testGetOldPortfolioValueDouble() {
        //setup - create new Portfolio, create MS, add stock to portfolio
        portfolio = new Portfolio();
        MemeStock tsla = new MemeStock("TSLA", 852);
        portfolio.addStock(tsla);

        //invoke desired behaviour - getOldPortfolioValueDouble
        double oldVal = portfolio.getOldPortfolioValueDouble();

        //check output
        assertNotNull(oldVal);
        assertNotEquals(oldVal, portfolio.getCurrentPortfolioValueDouble());
    }

}

