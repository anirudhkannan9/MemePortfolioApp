package model.stock;


import java.util.Random;

//interface that represents functionality & data to be implemented by Stock objects
public interface Stock {

    void changeValueOverTime(double d);

    double randomDouble();

    //getters that each Stock should implement (additional comment for commit)
    String getStockTicker();

    double getCurrentValueDouble();

    String getCurrentValueString();

    double getPercentChangeDouble();

    String getPercentChangeString();


}
