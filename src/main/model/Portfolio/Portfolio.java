package model.Portfolio;



import model.Stock.*;

import java.util.ArrayList;
import java.util.List;

//The Portfolio class represents information about a user's portfolio of MemeStock(s), and operations that
//can be conducted on the Portfolio as a whole

public class Portfolio {
    //constants
    private final double CHICKEN_TENDIES_PRICE = 1.099;

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
    public List<Stock> getPortfolio() {
        return portfolio;
    }

    public double getOldPortfolioValueDouble() {
        return oldPortfolioValue;
    }

    public String getOldPortfolioValueString() {
        return String.valueOf(oldPortfolioValue);
    }

    public double getCurrentPortfolioValueDouble() {
        double val = 0;
        for (Stock s : portfolio) {
            val += s.getCurrentValueDouble();
        }
        currentPortfolioValue = val;
        return currentPortfolioValue;
    }

    public String getCurrentPortfolioValueString() {
        return String.valueOf(getCurrentPortfolioValueDouble());
    }

    public double getPercentChangeDouble() {
        if (oldPortfolioValue != 0) {
            percentChange = ((currentPortfolioValue - oldPortfolioValue) / oldPortfolioValue) * 100;
        } else {
            percentChange = 0;
        }

        return percentChange;
    }

    public String getPercentChangeString() {
        return String.valueOf(getPercentChangeDouble());
    }

    //setters

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: adds Stock to portfolio (List<Stock>)
    public void addStock(Stock s) {
        String ticker = s.getStockTicker();
        boolean alreadyThere = false;

        for (Stock stock : portfolio) {
            if (stock.getStockTicker().equals(ticker)) {
                alreadyThere = true;
            }
        }

        if (!alreadyThere) {
            portfolio.add(s);
            currentPortfolioValue += s.getCurrentValueDouble();
        }
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


    //REQUIRES: Stock s exists in portfolio (same ticker as a stock in the portfolio)
    //MODIFIES: this
    //EFFECTS: "Sells" stock (removes from list; subtracts currentValue of Stock from portfolioValue;
    // displays corresponding message
    public String sellStock(Stock s) {
        String output = "";
        portfolio.remove(s);
        currentPortfolioValue -= s.getCurrentValueDouble();
        output = "SOLD: " + s.getStockTicker() + " for $" + s.getCurrentValueString();
        return output;
    }

    //REQUIRES: non-empty portfolio
    //MODIFIES:
    //EFFECTS: prints out message summarizing current holdings
    public String holdTheLine() {
        String msg = "HOLD THE LINE!!!! Diamond hands babyyyy ";
        String currentStocks = "\n Keeping you in: ";

        for (Stock s : portfolio) {
            currentStocks += s.getStockTicker() + " @ $" + s.getCurrentValueString() + ", ";
            //currentStocks += "@ ";
        }

        return msg + currentStocks;
    }


    //REQUIRES: non-empty portfolio
    //MODIFIES: this
    //EFFECTS: liquidates (sells) all stocks (MS&BS) in portfolio, adds up cash value and presents in msg to user
//    public String liquidateGetTendies() {
//        String liquidateOutput = "";
//        double cashOnHand = 0;
//        oldPortfolioValue = currentPortfolioValue;
//        List<Stock> portfolioCopy = portfolio;
//
//        //loop through all stocks in portfolio, removing from portfolio, and adding ticker and value to final message
//        for (Stock s : portfolioCopy) {
//            String stockSoldMessage = sellStock(s);
//            //portfolio.remove(s);
//            //stockSoldMessage = "\n SOLD: " + s.getStockTicker() + " for $" + s.getCurrentValueString();
//            liquidateOutput += stockSoldMessage;
//            cashOnHand += s.getCurrentValueDouble();
//        }
//
//        currentPortfolioValue = 0;
//        liquidateOutput += "\n Portfolio empty. Portfolio value: $" + String.valueOf(currentPortfolioValue);
//        liquidateOutput += "\n Cash on hand: $" + String.valueOf(cashOnHand);
//        double numOfTendies = cashOnHand / CHICKEN_TENDIES_PRICE;
//        liquidateOutput +=
//                "\n Go get them tendies baby. You can afford: "
//                + String.valueOf(numOfTendies)
//                + " tendies.";
//
//        return liquidateOutput;
//    }

    public String liquidateGetTendies() {
        String liquidateOutput = "";
        double cashOnHand = 0;
        oldPortfolioValue = currentPortfolioValue;
        List<Stock> stocksToRemove = new ArrayList<Stock>();

        //loop through all stocks in portfolio, adding ticker + value to final message and adding s to list of stocks
        //to remove from portfolio
        for (Stock s : portfolio) {
            String stockSoldMessage = "\n SOLD: " + s.getStockTicker() + " for $ " + s.getCurrentValueString();
            liquidateOutput += stockSoldMessage;
            cashOnHand += s.getCurrentValueDouble();
            stocksToRemove.add(s);
        }

        //remove all stocks from Portfolio
        portfolio.removeAll(stocksToRemove);

        //prepare final message regarding portfolio, cash on hand after liquidating, how many chicken tendies
        //user can buy with the cashOnHand
        currentPortfolioValue = 0;
        liquidateOutput += "\n Portfolio empty. Portfolio value: $" + String.valueOf(currentPortfolioValue);
        liquidateOutput += "\n Cash on hand: $" + String.valueOf(cashOnHand);
        double numOfTendies = cashOnHand / CHICKEN_TENDIES_PRICE;
        liquidateOutput +=
                "\n Go get them tendies baby. You can afford: "
                + String.valueOf(numOfTendies)
                + " tendies.";

        return liquidateOutput;

    }

    //REQUIRES: portfolio has at least one stock
    //MODIFIES: this
    //EFFECTS: calls changeValueOverTime on each of the stocks in the portfolio
    //updates oldPortfolioValue, currentPortfolioValue, and percentChange
    public String changePortfolioValueOverTime() {
        oldPortfolioValue = currentPortfolioValue;

        for (Stock s : portfolio) {
            //already class-specific implementation
            s.changeValueOverTime();
        }

        currentPortfolioValue = getCurrentPortfolioValueDouble();
        percentChange = ((currentPortfolioValue - oldPortfolioValue) / oldPortfolioValue) * 100;

        String output = "Your portfolio used to be worth: $" + getOldPortfolioValueString();
        output += "\n Your portfolio has changed " + getPercentChangeString() + "%";
        output += "\n Your portfolio is now worth: $" + getCurrentPortfolioValueString();

        return output;
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public String consultWifesBoyfriend() {
        return "";
    }




//    //REQUIRES:
//    //MODIFIES:
//    //EFFECTS:
//    //TODO: delete this method? Can do in constructor and then never change?
//    public void setInvestorType() {}


}
