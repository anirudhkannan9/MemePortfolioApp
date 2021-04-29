package ui;

import model.portfolio.Portfolio;
import model.stock.BoringStock;
import model.stock.MemeStock;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panels.ButtonPanel;
import ui.panels.PortfolioPanel;
import ui.panels.SummaryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//REFERENCES: derived from SpaceInvaders project
//represents the creation & running of a console version of the MemePortfolioAppGUI

public class MemePortfolioAppGUI extends JFrame {
    //fields
    private Portfolio portfolio;
    private PortfolioPanel pp;
    private SummaryPanel sp;
    private ButtonPanel bp;

    //MODIFIES: this
    //EFFECTS: sets up window in which Portfolio can be interacted with
    public MemePortfolioAppGUI() {
        super("Meme Portfolio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        portfolio = new Portfolio();
        //portfolio.addStock(new MemeStock("PLTR", 27));
        //portfolio.addStock(new MemeStock("GME", 265));
        //portfolio.addStock(new BoringStock("BRK.A", 284000));
        pp = new PortfolioPanel(portfolio);
        sp = new SummaryPanel(portfolio);
        bp = new ButtonPanel(this, sp, portfolio);
        add(pp);
        add(sp, BorderLayout.NORTH);
        add(bp, BorderLayout.SOUTH);
        pack();
        centreOnScreen();
        setVisible(true);
        //addTimer();
    }

    //EFFECTS: returns this.portfolio
    public Portfolio getPortfolio() {
        return this.portfolio;
    }

    // MODIFIES: this
    // EFFECTS:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }


    //MODIFIES: this
    // Start the Portfolio
    public static void main(String[] args) {
        new MemePortfolioAppGUI();
        new MemePortfolioAppConsole();
    }
}
