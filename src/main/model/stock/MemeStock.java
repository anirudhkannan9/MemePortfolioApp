package model.stock;

import org.json.JSONObject;

import java.util.Random;

//The MemeStock class represents the information of a stock that a user can add to/have in their portfolio
public class MemeStock implements Stock, RandomDouble {
    //constants
    static final double CHANCE_OF_BOOM = 0.1;

    //fields
    private String type = "MemeStock";
    double oldValue;
    double currentValue;
    double percentChange = 0;
    String stockTicker;

    //constructor
    //REQUIRES: val > 0
    public MemeStock(String st, double val) {
        this.stockTicker = st;
        this.currentValue = val;
    }

    //getters
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

    public double getOldValueDouble() {
        return oldValue;
    }

    public String getOldValueString() {
        return String.valueOf(oldValue);
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
    //EFFECTS: 15% chance that the stock value goes up 10x of its currentValue
    //oldValue is the currentValue before this method is called, currentValue is the new value
    //if the stock booms, and percentChange is the percent difference between the two if the stock booms
    public void changeValueOverTime(double d) {
        //Random random = new Random();
        //double randomDouble = rd.randomDouble();
        oldValue = currentValue;
        if (d > CHANCE_OF_BOOM) {
            currentValue *= 1.01;
            percentChange = 1;
        } else {
            currentValue *= 5;
            percentChange = 500;
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("ticker", stockTicker);
        json.put("value", getCurrentValueString());
        return json;
    }

}
