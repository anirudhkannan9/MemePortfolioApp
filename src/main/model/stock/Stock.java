package model.stock;


import java.util.Random;

//interface that represents functionality & data to be implemented by Stock objects
public interface Stock {

    public void changeValueOverTime(double d);
    
    public double randomDouble();

    //getters that each Stock should implement
    String getStockTicker();

    double getCurrentValueDouble();

    String getCurrentValueString();

    double getPercentChangeDouble();

    String getPercentChangeString();


}
