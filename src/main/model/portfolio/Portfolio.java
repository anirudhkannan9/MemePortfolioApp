package model.portfolio;



import model.stock.Stock;
import model.stock.BoringStock;
import model.stock.MemeStock;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//The Portfolio class represents information about a user's portfolio of MemeStock(s), and operations that
//can be conducted on the Portfolio as a whole

public class Portfolio implements Writable {
    //constants
    private static final double CHICKEN_TENDIES_PRICE = 1.099;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    //fields
    List<Stock> portfolio;
    double oldPortfolioValue = 0;
    double currentPortfolioValue;
    double percentChange;

    //MODIFIES: this
    //EFFECTS: creates portfolio with no stocks and value of 0
    public Portfolio() {
        portfolio = new ArrayList<>();
        currentPortfolioValue = 0;
    }

    // EFFECTS: returns a list of stocks in this portfolio
    public List<Stock> getStocks() {
        //return Collections.unmodifiableList(portfolio);
        return portfolio;
    }

    //EFFECTS: sets list of stocks to list passed in as argument
    public void setStocks(List<Stock> stocks) {
        portfolio = stocks;
    }

    //EFFECTS: returns oldPortfolioValue as a double
    public double getOldPortfolioValueDouble() {
        return oldPortfolioValue;
    }

    //EFFECTS: returns oldPortfolioValue as a string
    public String getOldPortfolioValueString() {
        return String.valueOf(oldPortfolioValue);
    }

    //EFFECTS: returns currentPortfolioValue as a double
    public double getCurrentPortfolioValueDouble() {
        double val = 0;
        for (Stock s : portfolio) {
            val += s.getCurrentValueDouble();
        }
        currentPortfolioValue = Math.floor(val);
        return currentPortfolioValue;
    }

    //EFFECTS: returns currentPortfolioValue as a string
    public String getCurrentPortfolioValueString() {
        return String.valueOf(getCurrentPortfolioValueDouble());
    }

    //EFFECTS: returns percentChange as a double
    public double getPercentChangeDouble() {
        if (oldPortfolioValue != 0) {
            percentChange = Math.floor(((currentPortfolioValue - oldPortfolioValue) / oldPortfolioValue) * 100);
        } else {
            percentChange = 0;
        }

        return percentChange;
    }

    //EFFECTS: returns percentChange as a string
    public String getPercentChangeString() {
        return String.valueOf(getPercentChangeDouble());
    }

    //EFFECTS: returns size of this.portfolio
    public int numStocks() {
        return portfolio.size();
    }

    //setters

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: adds Stock to portfolio (List<Stock>)
    public void addStock(Stock s) {
//        String ticker = s.getStockTicker();
//        boolean alreadyThere = false;
//
//        for (Stock stock : portfolio) {
//            if (stock.getStockTicker().equals(ticker)) {
//                alreadyThere = true;
//            }
//        }

        if (!alreadyThere(s)) {
            portfolio.add(s);
            currentPortfolioValue += s.getCurrentValueDouble();
        }
    }

    //REQUIRES:
    //modifies:
    //EFFECTS: checks if stock already in portfolio
    public boolean alreadyThere(Stock s) {
        String ticker = s.getStockTicker();
        boolean alreadyThere = false;
        for (Stock stock : portfolio) {
            if (stock.getStockTicker().equals(ticker)) {
                alreadyThere = true;
            }
        }
        return alreadyThere;
    }


    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints a summary of the currentValue and change thereof (if any) of all stocks in the Portfolio
    public String viewLossPorn() {
        String summary = "POSITIONS";

        //add info regarding change in individual stocks to summary string
        for (Stock s : portfolio) {
            String stockinfo =
                    "\n" + " - " + s.getStockTicker()
                            + ": $" + s.getCurrentValueString()
                            + "; " + s.getPercentChangeString() + "%";
            summary += stockinfo;

        }

        //add info regarding new Portfolio value ($) to summary string
        summary += "\n \n" + " - " + "NEW VALUE: $" + String.valueOf(currentPortfolioValue);

        //add info regarding change in total portfolio ($) to summary string
        summary += "\n" + " - " + "TOTAL CHANGE: $" + String.valueOf(currentPortfolioValue - oldPortfolioValue);

        //add info regarding change in total portfolio (%) to summary string
        summary += "\n" + " - " + "PERCENT CHANGE: " + String.valueOf(percentChange) + "%";

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
            currentStocks += "\n" + s.getStockTicker() + " @ $" + s.getCurrentValueString() + ", ";
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

    //REQUIRES: non-empty portfolio
    //MODIFIES: this
    //EFFECTS: sells all stocks, prints descriptive message
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
            double d = s.randomDouble();
            s.changeValueOverTime(d);
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
    //EFFECTS: returns a piece of advice (String) from the list in the WifesBoyfriendsAdvice class
    public String consultWifesBoyfriend() {
        return WifesBoyfriendsAdvice.getAdvice();
    }

    //EFFECTS: translates portfolio to JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        //json.put("name", name);
        json.put("stocks", stocksToJson());
        return json;
    }

    // EFFECTS: returns stocks in this portfolio as a JSON array
    private JSONArray stocksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Stock s : portfolio) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

}
