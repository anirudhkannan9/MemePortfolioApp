package ui;

import model.portfolio.Portfolio;
import model.stock.MemeStock;
import model.stock.Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class MemePortfolioApp {
    private Scanner input;
    private Portfolio portfolio;
    private ArrayList<MemeStock> memeStocks;

    //EFFECTS: runs the meme portfolio application
    public MemePortfolioApp() {
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

//    private void processCommand(String command) {
//        if (command.equals("c")) {
//            doDeposit();
//        } else if (command.equals("w")) {
//            doWithdrawal();
//        } else if (command.equals("t")) {
//            doTransfer();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }

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
        } else if (command.equals("s")) {
            viewLossPorn();
        } else if (command.equals("l")) {
            liquidatePortfolio();
        } else if (command.equals("h")) {
            holdTheLine();
        } else {
            System.out.println("Selection not valid. Please select from the options provided.");
        }
    }
    // MODIFIES: this
    // EFFECTS: initializes state of Scanner input

    private void init() {
        //cheq = new Account("Joe", 145.00);
        //sav = new Account("Joe", 256.50);
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tc -> create a portfolio");
        System.out.println("\tm -> choose a meme stock to add to your portfolio");
        System.out.println("\tb -> create your own stock to add to your portfolio");
        System.out.println("\ti -> increment time");
        System.out.println("\ts -> see how your portfolio is doing");
        System.out.println("\tl -> liquidate your portfolio");
        System.out.println("\th -> hold the line - don't sell anything - diamond hands baby");
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
        //add pre-defined MemeStocks to list memeStocks
        populateMemeStocks();

        //display list of MemeStocks, along w/ number

        //prompt user input

        //process user input

        //recursive behaviour - call again?

        //handle case when user has added all MemeStocks
    }

    private void populateMemeStocks() {
        //create new MemeStocks
        this.memeStocks.add(new MemeStock("TSLA", 815));
        this.memeStocks.add(new MemeStock("PLTR", 36));
        this.memeStocks.add(new MemeStock("FB", 269));
        this.memeStocks.add(new MemeStock("ABCL", 40));
        //abnb
        //dash
        //CMPS
        //MMED.NE
        //LAZR
        //gme
        //slvr
        //amc
        //bb
        //nio
        //rkt
        //baba
        //gm
        //amd
        //nkla
        //amzn
        //msft
        //aapl
        //bynd
        //zm
        //qqq
        //ge
        //pton
        //nvda
        //add to this.memeStocks
    }

    private void addBoringStock() {}

    private void incrementTime() {}

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints out summary of how your holdings have fared
    private void viewLossPorn() {
        System.out.println("Summarizing your losses so far. Hope those hands aren't getting papery...");
        System.out.println("Summary: ");
        System.out.println(portfolio.viewLossPorn());
    }

    private void liquidatePortfolio() {}

    private void holdTheLine() {}

}
