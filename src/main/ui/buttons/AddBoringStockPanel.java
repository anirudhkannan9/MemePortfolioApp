package ui.buttons;

import model.portfolio.Portfolio;
import model.stock.BoringStock;
import ui.MemePortfolioAppGUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.lang.Double.parseDouble;

//represents a panel containing buttons allowing the user to add BoringStocks

public class AddBoringStockPanel extends JPanel {

    //MODIFIES: this
    //EFFECTS: constructs AddBoringStockPanel referring to the given MemePortfolioAppGUI, Portfolio
    //and creates button and corresponding action listener allowing user to add BoringStock
    public AddBoringStockPanel(MemePortfolioAppGUI memePortfolioAppGUI, Portfolio p) {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Create a boring stock to add to your portfolio"));

        JLabel tickerLabel = new JLabel("Stock Ticker: ");
        JLabel priceLabel = new JLabel("Stock price: $");
        JTextField tickerField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JButton addBtn = new JButton("Add to Portfolio");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("./button.wav");
                p.addStock(new BoringStock(tickerField.getText(), parseDouble(priceField.getText())));
                memePortfolioAppGUI.repaint();
            }
        });

        setLayout(new GridBagLayout());
        handleGridBagConstraints(tickerLabel, priceLabel, tickerField, priceField, addBtn);
    }

    private void handleGridBagConstraints(
            JLabel tickerLabel,
            JLabel priceLabel,
            JTextField tickerField,
            JTextField priceField,
            JButton addBtn) {
        GridBagConstraints gc = new GridBagConstraints();

        //First column:
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        add(tickerLabel, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(priceLabel, gc);

        //Second column
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 0;
        add(tickerField, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(priceField, gc);

        //final row
        gc.weighty = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);
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
}
