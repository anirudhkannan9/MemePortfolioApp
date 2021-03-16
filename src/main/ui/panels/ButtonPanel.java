package ui.panels;

import model.portfolio.Portfolio;
import ui.MemePortfolioAppGUI;
import ui.buttons.AddMemeStockFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private Portfolio portfolio;
    private static final int BTN_WIDTH = 150;
    private static final int BTN_HEIGHT = 30;
    private JButton addMemeStockBtn;
    private JButton addBoringStockButton;
    private JButton incrementTimeButton;
    private JButton saveButton;
    private JButton loadButton;
    private MemePortfolioAppGUI memePortfolioAppGUI;

    //EFFECTS: sets size and background colour of panel, updates this with portfolio to be interacted with
    //creates button
    public ButtonPanel(MemePortfolioAppGUI memePortfolioAppGUI, Portfolio p) {
        portfolio = p;
        setBackground(new Color(180, 180, 180));
        addButtons(portfolio);
        this.memePortfolioAppGUI = memePortfolioAppGUI;
    }

    //MODIFIES: this
    //EFFECTS: adds all buttons to panel
    public void addButtons(Portfolio p) {
        addAddMemeStockButton(p);
        addAddBoringStockButton(p);
        addIncrementTimeButton();
        addSaveButton(p);
        addLoadButton(p);
        //TODO: save
        //TODO: load
    }

    //EFFECTS: adds addMemeStockButton to panel
    public void addAddMemeStockButton(Portfolio p) {
        addMemeStockBtn = new JButton("Add Meme Stock");
        addMemeStockBtn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        addMemeStockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed");
                AddMemeStockFrame amsf = new AddMemeStockFrame(memePortfolioAppGUI, p);
            }
        });
        add(addMemeStockBtn);
    }

    //MODIFIES: this
    //EFFECTS: adds addBoringStockButton to panel
    public void addAddBoringStockButton(Portfolio p) {
        addBoringStockButton = new JButton("Add Boring Stock");
        addBoringStockButton.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        addBoringStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("add boring stock button pressed");
                //AddBoringStockFrame absf = new AddBoringStockFrame(p);
            }
        });
        add(addBoringStockButton);
    }

    //MODIFIES: this
    //EFFECTS: adds increment time button to panel
    public void addIncrementTimeButton() {
        incrementTimeButton = new JButton("Increment Time");
        incrementTimeButton.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        incrementTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("increment time button pressed");
                portfolio.changePortfolioValueOverTime();
                //re-render/re-display
            }
        });
        add(incrementTimeButton);
    }

    //MODIFIES: this
    //EFFECTS: adds save button to panel
    public void addSaveButton(Portfolio p) {
        saveButton = new JButton("Save Portfolio");
        saveButton.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("save button pressed");
                //TODO: save
                //TODO: some kind of display that it's been saved?
            }
        });
        add(saveButton);
    }

    //MODIFIES: this
    //EFFECTS: adds load button to panel
    public void addLoadButton(Portfolio p) {
        saveButton = new JButton("Load previously saved Portfolio");
    }

    //

    //placing button on panel -> click -> ActionListener will respond to click
    //current panel set to invisible, construct new visible panel w/ desired functionality
    //if different sizes, more than one panel can be visible
    //how do you arrange all the components on the JPanel?
    //getting button to open a new Frame








}
