package ui.buttons;

import model.portfolio.Portfolio;
import model.stock.MemeStock;
import ui.MemePortfolioAppGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddMemeStockFrame extends JFrame {

    private Portfolio portfolio;
    private List<MemeStock> memeStocks = new ArrayList<>();
    private AddMemeStockPanel addMemeStockPanel;

    public AddMemeStockFrame(MemePortfolioAppGUI memePortfolioAppGUI, Portfolio p) {
        setSize(380, 480);
        centreOnScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.BLACK);
        setFont(new Font("Andale Mono", Font.BOLD, 18));
        setForeground(Color.GREEN);
        this.portfolio = p;
        addMemeStockPanel = new AddMemeStockPanel(memePortfolioAppGUI, portfolio);
        getContentPane().add(addMemeStockPanel);

    }

    // MODIFIES: this
    // EFFECTS:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }



}
