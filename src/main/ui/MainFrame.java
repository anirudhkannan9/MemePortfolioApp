package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private DetailsPanel detailsPanel;

    public MainFrame(String title) {
        super(title);
        //adding components: 3 steps

        //1. Set layout manager (decides how to arrange components on Frame)
        //BorderLayout lets you add components to top/bottom/l/r/centre; for building basic frame
        setLayout(new BorderLayout());

        //2. Create Swing components
        JTextArea textArea = new JTextArea();
        //JButton button = new JButton("Click me!");
        detailsPanel = new DetailsPanel();
        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event) {
                String text = event.getText();
                textArea.append(text);
            }
        });

        //3. Add Swing components to JFrame's content pane
        Container c = getContentPane();

        //when adding a component to container, specify static constant that says where it goes
        c.add(textArea, BorderLayout.CENTER);
        //c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.WEST);

    }
}
