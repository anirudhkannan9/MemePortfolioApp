package ui;

import model.portfolio.Portfolio;
import model.stock.BoringStock;
import model.stock.MemeStock;
import model.stock.Stock;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MemePortfolioApp {
    private static final String JSON_STORE = "./data/portfolio.json";
    private Scanner input;
    private Portfolio portfolio;
    private List<Stock> memeStocks = new ArrayList<>();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs application
    //TODO: construction of portfolio that should happen here
    public MemePortfolioApp() {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runMemePortfolio();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runMemePortfolio() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Goodbye!");
    }


    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("c")) {
            createPortfolio();
        } else if (portfolio == null) {
            System.out.println("You have to create your portfolio before you can interact with it, silly.");
        } else if (command.equals("m")) {
            addMemeStock();
        } else if (command.equals("b")) {
            addBoringStock();
        } else if (command.equals("i")) {
            incrementTime();
        } else if (command.equals("v")) {
            viewLossPorn();
        } else if (command.equals("a")) {
            consultWifesBoyfriend();
        } else if (command.equals("l")) {
            liquidatePortfolio();
        } else if (command.equals("h")) {
            holdTheLine();
        } else if (command.equals("s")) {
            savePortfolio();
        } else if (command.equals("r")) {
            readPortfolio();
        } else {
            System.out.println("Selection not valid. Please select from the options provided.");
        }
    }
    // MODIFIES: this
    // EFFECTS: initializes state of Scanner input

    //MODIFIES: this(.input)
    //EFFECTS: initializes scanner
    private void init() {
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tc -> create a portfolio");
        System.out.println("\tm -> choose a meme stock to add to your portfolio");
        System.out.println("\tb -> create your own stock to add to your portfolio");
        System.out.println("\ti -> increment time");
        System.out.println("\tv -> view your portfolio");
        System.out.println("\ta -> get advice from your wife's boyfriend");
        System.out.println("\tl -> liquidate your portfolio");
        System.out.println("\th -> hold the line - don't sell anything - diamond hands baby");
        System.out.println("\ts -> save your portfolio to a file");
        System.out.println("\tr -> read and load your previously saved portfolio from a file");
        System.out.println("\tq -> quit");
    }

    //REQUIRES:
    //MODIFIES: portfolio
    //EFFECTS: prints out statements relating to portfolio formation
    //then displays summary of holdings (none) in new portfolio
    private void createPortfolio() {
        System.out.println("Creating a new portfolio for you. In the meantime: halkidiki?");
        portfolio = new Portfolio();
        System.out.println("Created your portfolio. Summary: ");
        System.out.println(portfolio.viewLossPorn());
    }

    //REQUIRES:
    //MODIFIES: portfolio, list of memeStocks
    //EFFECTS: adds pre-defined MemeStocks to list of MemeStocks to be displayed to user
    //Adds the MemeStock(s) that the user selects to portfolio, removes from list memeStocks
    private void addMemeStock() {
        //add pre-defined MemeStocks to list memeStocks, if empty
        if (memeStocks.size() == 0) {
            populateMemeStocks();
        }
        boolean keepAddingMemeStock = true;

        while (keepAddingMemeStock) {
            //prompt user input
            System.out.println("Please enter the number of the meme stock you'd like to YOLO (add to your portfolio).");
            //display list of MemeStocks, along w/ number
            int i = 0;
            for (Stock s : memeStocks) {
                i++;
                System.out.println(String.valueOf(i) + ". " + s.getStockTicker() + " @ $" + s.getCurrentValueString());
            }
            System.out.println("\nType any letter to return to the main menu");

            //process user input
            keepAddingMemeStock = processAddingMemeStockInput(keepAddingMemeStock);
        }
    }

    //REQUIRES: boolean keepAddingMemeStock is true initially
    //MODIFIES: portfolio, memeStocks
    //EFFECTS: processes user input with regards to adding MemeStock to portfolio
    private boolean processAddingMemeStockInput(boolean keepAddingMemeStock) {
        try {
            int command = input.nextInt();
            if (command > 23) {
                System.out.println("Please choose an element from within the list.");
            } else {
                command--;
                Stock stockToAdd = memeStocks.get(command);
                portfolio.addStock(stockToAdd);
                memeStocks.remove(stockToAdd);
                System.out.println("Added " + stockToAdd.getStockTicker() + " to your portfolio.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Returning to main menu.");
            keepAddingMemeStock = false;
            String command = input.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose an element from within the list.");
        }
        return keepAddingMemeStock;
    }


    //REQUIRES:
    //MODIFIES: this(.memeStocks)
    //EFFECTS: populates this.memeStocks with pre-defined list of MemeStocks that user can add to portfolio
    private void populateMemeStocks() {
        //create new MemeStocks
        this.memeStocks.add(new MemeStock("TSLA", 815));
        this.memeStocks.add(new MemeStock("PLTR", 36));
        this.memeStocks.add(new MemeStock("FB", 269));
        this.memeStocks.add(new MemeStock("ABCL", 40));
        this.memeStocks.add(new MemeStock("ABNB", 211));
        this.memeStocks.add(new MemeStock("DASH", 211));
        this.memeStocks.add(new MemeStock("CMPS", 45));
        this.memeStocks.add(new MemeStock("MMED.NE", 4));
        this.memeStocks.add(new MemeStock("LAZR", 34));
        this.memeStocks.add(new MemeStock("GME", 58));
        this.memeStocks.add(new MemeStock("AMC", 6));
        this.memeStocks.add(new MemeStock("BB", 13));
        this.memeStocks.add(new MemeStock("RKT", 211));
        this.memeStocks.add(new MemeStock("GM", 54));
        this.memeStocks.add(new MemeStock("AMD", 92));
        this.memeStocks.add(new MemeStock("NKLA", 23));
        this.memeStocks.add(new MemeStock("AMZN", 3270));
        this.memeStocks.add(new MemeStock("MSFT", 242));
        this.memeStocks.add(new MemeStock("AAPL", 135));
        this.memeStocks.add(new MemeStock("BYND", 173));
        this.memeStocks.add(new MemeStock("ZM", 430));
        this.memeStocks.add(new MemeStock("PTON", 147));
        this.memeStocks.add(new MemeStock("NVDA", 586));
    }

    //REQUIRES:
    //MODIFIES: this.portfolio
    //EFFECTS: prompts user to provide a ticker and a price, creates a stock accordingly, and adds to portfolio
    //displays what portfolio looks like after adding user-created stock
    private void addBoringStock() {
        //prompt user input: Ticker
        System.out.println("Enter the ticker of the stock you'd like to add:");
        String ticker = input.next();

        //prompt user input: Stock price
        System.out.println("Enter the price of the stock you'd like to add:");
        int price = 0;
        try {
            price = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please only enter integers for the stock price.");
            price = input.nextInt();
        }

        //add stock to portfolio
        System.out.println("Adding '" + ticker + "' to your portfolio @ $" + price);
        BoringStock bs = new BoringStock(ticker, price);
        portfolio.addStock(bs);

        //summarizing new portfolio with stock added
        System.out.println("Your portfolio currently contains: ");
        System.out.println(portfolio.viewLossPorn());
    }

    //REQUIRES: non-empty portfolio
    //MODIFIES: this.portfolio
    //EFFECTS: calls changePortfolioValueOverTime() on this.portfolio
    private void incrementTime() {
        portfolio.changePortfolioValueOverTime();
        System.out.println("Some time has passed. Your portfolio looks different.");
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints out summary of how your holdings have fared
    private void viewLossPorn() {
        System.out.println("Summarizing your losses so far. Hope those hands aren't getting papery...");
        System.out.println("Summary: ");
        System.out.println(portfolio.viewLossPorn());
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints out some advice from your wife's boyfriend, complete with dramatic pauses
    private void consultWifesBoyfriend() {
        System.out.println("You've chosen to consult with your wife's boyfriend. Here are his dictums: ");
        wait(3);
        System.out.println("-----------------------------");
        System.out.println("1. " + portfolio.consultWifesBoyfriend());
        wait(4);
        System.out.println("-----------------------------");
        System.out.println("2. " + portfolio.consultWifesBoyfriend());
        wait(4);
        System.out.println("-----------------------------");
        System.out.println("3. " + portfolio.consultWifesBoyfriend());
        System.out.println("-----------------------------");
        wait(4);
        System.out.println("\nChad has spoken.");
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: waits for i seconds
    private void wait(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            System.out.println("Nothing to see here...");
        }
    }

    //REQUIRES: portfolio is non-empty
    //MODIFIES: this.portfolio
    //EFFECTS: calls portfolio.liquidateGetTendies() on this.portfolio
    private void liquidatePortfolio() {
        System.out.println("Liquidating all your holdings. Paper hands :(");
        System.out.println(portfolio.liquidateGetTendies());
    }

    //REQUIRES: portfolio is non-empty
    //MODIFIES:
    //EFFECTS calls portfolio.holdTheLine() on this.portfolio
    private void holdTheLine() {
        System.out.println(portfolio.holdTheLine());
    }

    //REQUIRES: portfolio has been instantiated
    //MODIFIES: this
    //EFFECTS: saves the workroom to file
    private void savePortfolio() {
        try {
            jsonWriter.open();
            jsonWriter.write(portfolio);
            jsonWriter.close();
            System.out.println("Saved portfolio to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: reads portfolio from file
    private void readPortfolio() {
        try {
            portfolio = jsonReader.read();
            System.out.println("Loaded portfolio from" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
