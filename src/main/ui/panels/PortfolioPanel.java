package ui.panels;

import com.sun.javafx.UnmodifiableArrayList;
import model.portfolio.Portfolio;
import model.stock.MemeStock;
import model.stock.Stock;
import sun.font.Font2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//represents a panel upon which textual data representing the portfolio's state is written
public class PortfolioPanel extends JPanel {

    //fields e.g. Strings that display messages
    private Portfolio portfolio;

    // EFFECTS:  sets size and background colour of panel,
    //           updates this with the portfolio to be displayed
    public PortfolioPanel(Portfolio p) {
        setPreferredSize(new Dimension(Portfolio.WIDTH, Portfolio.HEIGHT));
        setBackground(Color.BLACK);
        setFont(new Font("Andale Mono", Font.BOLD, 18));
        setForeground(Color.GREEN);
        this.portfolio = p;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPortfolio(g);
    }

    // MODIFIES: g
    // EFFECTS:  draws the portfolio onto g
    private void drawPortfolio(Graphics g) {
        drawStocks(g);
        //drawInvaders(g);
        //drawMissiles(g);
    }

    // MODIFIES: g
    // EFFECTS:  draws the stocks onto g
    private void drawStocks(Graphics g) {
        //create a list that contains all stocks in the Portfolio
        List<Stock> stocks = portfolio.getStocks();
        //create a 2nd list that only contains MemeStocks
        List<Stock> memeStocks = new ArrayList<>();
        List<Stock> boringStocks = new ArrayList<>();
        //separate stocks into Meme and Boring
        for (Stock s : stocks) {
            if (s instanceof MemeStock) {
                memeStocks.add(s);
            } else {
                boringStocks.add(s);
            }
        }

        //display the stocks of each type
        g.drawString("MEME STOCKS: ", 5, 20);
        g.drawString("boring stocks: ", Portfolio.WIDTH / 2 + 5, 20);

        drawMemeStocks(g, memeStocks);
        drawBoringStocks(g, boringStocks);

        Color savedCol = g.getColor();
        g.setColor(savedCol);
    }

    //MODIFIES: g
    //EFFECTS: draws list of MemeStock onto g
    private void drawMemeStocks(Graphics g, List<Stock> memeStocks) {
        int x = 5;
        int y = 20;
        y += 25;
        for (Stock ms : memeStocks) {
            String summary = ms.getStockSummary();
            g.drawString(summary, x, y);
            y += 25;

        }
    }

    //MODIFIES: g
    //EFFECTS: draws list of BoringStock onto g
    private void drawBoringStocks(Graphics g, List<Stock> boringStocks) {
        int x = Portfolio.WIDTH / 2 + 5;
        int y = 20;
        y += 25;
        for (Stock bs : boringStocks) {
            String summary = bs.getStockSummary();
            g.drawString(summary, x, y);
            y += 25;
        }
    }

}
