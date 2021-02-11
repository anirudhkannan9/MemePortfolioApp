
package model.stock;


import java.util.Random;

//The MemeStock class represents the information of a stock that a user can add to/have in their portfolio
public class BoringStock implements Stock {
    //constants
    //fields
    private double oldValue;
    private double currentValue;
    private double percentChange = 0;
    private String stockTicker;

    //constructor
    //REQUIRES: val > 0
    public BoringStock(String st, int val) {
        this.currentValue = val;
        this.stockTicker = st;
    }

    //getters
    public String getStockTicker() {
        return stockTicker;
    }

    public double getCurrentValueDouble() {
        return currentValue;
    }

    public String getCurrentValueString() {
        return String.valueOf(currentValue);
    }

    public double getPercentChangeDouble() {
        return percentChange;
    }

    public String getPercentChangeString() {
        return String.valueOf(percentChange);
    }

    //setters

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: produces random double (b/w 0 and 1) for changeValueOverTime to take as argument
    public double randomDouble() {
        Random random = new Random();
        return random.nextDouble();
    }

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: sets the oldValue to equal the currentValue before this method executes
    //depreciates the currentValue by 30% and sets the percentChange to -0.3, representing -30%
    public void changeValueOverTime(double d) {
        oldValue = currentValue;
        currentValue = 0.9 * currentValue;
        percentChange = -10;

    }

}
