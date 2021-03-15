
package model.stock;


import org.json.JSONObject;

import java.util.Random;

//The MemeStock class represents the information of a stock that a user can add to/have in their portfolio
public class BoringStock implements Stock {
    //constants
    static final double CHANCE_OF_BOOM = 0.0;

    //fields
    private String type = "BoringStock";
    private double oldValue;
    private double currentValue;
    private double percentChange = 0;
    private String stockTicker;

    //constructor
    //REQUIRES: val > 0
    public BoringStock(String st, double val) {
        this.stockTicker = st;
        this.currentValue = val;
    }

    //getters

    @Override
    public String getType() {
        return type;
    }

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

    @Override
    public double getChanceOfBoom() {
        return CHANCE_OF_BOOM;
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("ticker", stockTicker);
        json.put("value", getCurrentValueString());
        return json;
    }

    //EFFECTS: return String summarizing current state of this
    public String getStockSummary() {
        return "\n" + " - " + this.getStockTicker()
                + ": $" + this.getCurrentValueString()
                + "; " + this.getPercentChangeString() + "%";
    }

}
