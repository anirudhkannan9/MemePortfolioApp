package persistence;

import model.portfolio.Portfolio;
import model.stock.Stock;
import model.stock.BoringStock;
import model.stock.MemeStock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//REFERENCE: modelled on JsonReader class in JsonSerializationDemo project

// Represents a reader that reads portfolio from JSON data stored in file
public class JsonReader {
    private String source;

//comment for commit + push
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads portfolio from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Portfolio read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePortfolio(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            //stream.forEach(s -> contentBuilder.append(s));
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses portfolio from JSON object and returns it
    private Portfolio parsePortfolio(JSONObject jsonObject) {
        Portfolio p = new Portfolio();
        addStocks(p, jsonObject);
        return p;
    }

    // MODIFIES: p
    // EFFECTS: parses Stocks from JSON object and adds them to Portfolio
    private void addStocks(Portfolio p, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("stocks");
        for (Object json : jsonArray) {
            JSONObject nextStock = (JSONObject) json;
            addStock(p, nextStock);
        }
    }

    // MODIFIES: p
    // EFFECTS: parses stock from JSON object and adds it to portfolio
    private void addStock(Portfolio p, JSONObject jsonObject) {
        //get String properties of Stock: type (MS/BS), stockTicker, currentValue
        String type = jsonObject.getString("type");
        String ticker = jsonObject.getString("ticker");
        double currentValue = Double.parseDouble(jsonObject.getString("value"));
        if (type.equals("MemeStock")) {
            MemeStock stockToAdd = new MemeStock(ticker, currentValue);
            p.addStock(stockToAdd);
        } else if (type.equals("BoringStock")) {
            BoringStock stockToAdd = new BoringStock(ticker, currentValue);
            p.addStock(stockToAdd);
        }


    }
}
