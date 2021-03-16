package ui.panels;

import model.portfolio.Portfolio;

import javax.swing.*;
import java.awt.*;

public class SummaryPanel extends JPanel {
    //fields: with messages to be displayed
    private static final String PORTFOLIO_VAL_TXT = "Portfolio value: $";
    private static final String PERCENT_CHANGE_TXT = "Percent change: ";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private Portfolio portfolio;
    private JLabel valueLbl;
    private JLabel percentChangeLbl;

    // EFFECTS: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public SummaryPanel(Portfolio p) {
        portfolio = p;
        setBackground(new Color(180, 180, 180));
        valueLbl = new JLabel(PORTFOLIO_VAL_TXT + p.getCurrentPortfolioValueString());
        valueLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        percentChangeLbl = new JLabel(PERCENT_CHANGE_TXT + p.getPercentChangeString() + "%");
        percentChangeLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(valueLbl);
        add(Box.createHorizontalStrut(10));
        add(percentChangeLbl);
    }

    // MODIFIES: this
    // EFFECTS:  updates portfolio value and percent change
    //           to reflect current state of portfolio
    public void update() {
        valueLbl.setText(PORTFOLIO_VAL_TXT + portfolio.getCurrentPortfolioValueString());
        percentChangeLbl.setText(PERCENT_CHANGE_TXT + portfolio.getPercentChangeString() + "%");
        repaint();
    }



}
