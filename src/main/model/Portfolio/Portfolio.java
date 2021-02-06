package model.Portfolio;



import model.Stock.*;

import java.util.ArrayList;
import java.util.List;

//The Portfolio class represents information about a user's portfolio of MemeStock(s), and operations that
//can be conducted on the Portfolio as a whole

public class Portfolio {
    //constants



    //fields
    List<Stock> portfolio;
    double oldPortfolioValue = 0;
    double currentPortfolioValue;
    double percentChange;


    //constructor
    public Portfolio() {
        portfolio = new ArrayList<>();
        currentPortfolioValue = 0;
    }


    //getters
    public double getOldPortfolioValueDouble() {
        return oldPortfolioValue;
    }

    public String getOldPortfolioValueString() {
        return String.valueOf(oldPortfolioValue);
    }

    public double getCurrentPortfolioValueDouble() {
        return currentPortfolioValue;
    }

    public String getCurrentPortfolioValueString() {
        return String.valueOf(currentPortfolioValue);
    }

    public double getPercentChangeDouble() {
        return percentChange;
    }

    public String getPercentChangeString() {
        return String.valueOf(percentChange);
    }


    //setters

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: adds Stock to portfolio (List<Stock>)
    public void addStock(Stock s) {
        portfolio.add(s);
        currentPortfolioValue += s.getCurrentValueDouble();
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints a summary of the currentValue and change thereof (if any) of all stocks in the Portfolio
    public String viewLossPorn() {
        String summary = "";

        //add info regarding change in individual stocks to summary string
        for (Stock s : portfolio) {
            String stockinfo =
                    "\n"
                            + " - "
                            + s.getStockTicker()
                            + ": "
                            + s.getCurrentValueString()
                            + "; "
                            + s.getPercentChangeString();

            summary += stockinfo;

        }

        //add info regarding change in total portfolio ($) to summary string
        summary +=
                "\n \n"
                + " - "
                + "TOTAL CHANGE: "
                + String.valueOf(currentPortfolioValue - oldPortfolioValue);

        //add info regarding change in total portfolio (%) to summary string
        summary +=
                "\n"
                + "PERCENT CHANGE: "
                + String.valueOf(percentChange);

        return summary;
    }

    //REQUIRES: portfolio has at least one stock
    //MODIFIES: this
    //EFFECTS: calls changeValueOverTime on each of the stocks in the portfolio
    //updates oldPortfolioValue, currentPortfolioValue, and percentChange
    public void changePortfolioValueOverTime() {
        //stub
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public String liquidateGetTendies() {
        return "";
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public String holdTheLine() {
        return "";
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public String sellStock() {
        return "";
    }



    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    //TODO: delete this method? Can do in constructor and then never change?
    public void setInvestorType() {}

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public String consultWifesBoyfriend() {
        return "";
    }
}
