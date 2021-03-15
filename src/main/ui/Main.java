package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
//        try {
//            new MemePortfolioApp();
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }
        //new MemePortfolioApp();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame("Meme Portfolio App");
                frame.setSize(500, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}