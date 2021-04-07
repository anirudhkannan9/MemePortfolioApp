package ui.buttons;

import model.portfolio.Portfolio;
import model.stock.MemeStock;
import ui.MemePortfolioAppGUI;
import ui.panels.ButtonPanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddMemeStockPanel extends JPanel {
    //constants
    private static final int BTN_WIDTH = 180;
    private static final int BTN_HEIGHT = 30;

    //fields
    private Portfolio portfolio;
    private List<MemeStock> memeStocks = new ArrayList<>();
    private MemePortfolioAppGUI memePortfolioAppGUI;

    public AddMemeStockPanel(MemePortfolioAppGUI memePortfolioAppGUI, Portfolio p) {
        portfolio = p;
        setBackground(new Color(180, 180, 180));
        memeStocks = new ArrayList<>();
        this.memePortfolioAppGUI = memePortfolioAppGUI;
        drawMemeStockButtons();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void drawMemeStockButtons() {
        populateMemeStocks();
        //int x = 0;
        //int y = 0;
        for (MemeStock ms : memeStocks) {
            if (!portfolio.alreadyThere(ms)) {
                JButton addMemeStockBtn = new JButton(
                        "Add " + ms.getStockTicker() + " @ $" + ms.getCurrentValueString());
                addMemeStockBtn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
                addMemeStockBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println("add " + ms.getStockTicker());
                        playSound("./button.wav");
                        portfolio.addStock(ms);
                        remove(addMemeStockBtn);
                        //memePortfolioAppGUI.repaint();
                        memePortfolioAppGUI.revalidate();
                        memePortfolioAppGUI.repaint();
                        System.out.println("here: " + portfolio.getStocks());
                        System.out.println("out there: " + memePortfolioAppGUI.getPortfolio().getStocks());

                    }
                });
                //memeStockButtons.add(addMemeStockBtn);
                add(addMemeStockBtn);
            }

        }

//        for (JButton b : memeStockButtons) {
//            add(b);
//        }
//        MemeStock memeStockToAdd = memeStocks.get(0);
//        JButton addMemeStockBtn = new JButton("Add " + memeStockToAdd.getStockTicker());
//        addMemeStockBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("added " + memeStockToAdd.getStockTicker());
//            }
//        });
//        add(addMemeStockBtn);

    }

    //EFFECTS: plays sound based on path to audio file passed in
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
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


}
