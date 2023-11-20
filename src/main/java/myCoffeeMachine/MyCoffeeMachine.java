package myCoffeeMachine;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Class serves as a simple demonstration of my real-life coffee machine GUI and functionality.
 *
 * @author Martin Dekanovský
 */
public class MyCoffeeMachine extends JFrame {

    private static JTextArea textArea = new JTextArea();

    /**
     * Method for creating a coffee machine GUI.
     */
    public void createGUI() throws IOException {
        setTitle("My coffee machine :)");
        setLayout(new BorderLayout());
        setSize(610, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        textArea.setLayout(new BorderLayout());
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.BLACK);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        add(container, BorderLayout.SOUTH);

        container.add(Buttons.addRefillButtons());
        container.add(Buttons.addPrepareButtons());
        container.add(Buttons.addMaintenanceButtons());
        container.add(Buttons.addGeneralButtons());

        Functions.getInitialState();
    }

    /**
     * Method for adding the text to text area.
     *
     * @param text to be added to text area.
     */
    public static void addTextToTextArea(String text) {
        textArea.append(text);
    }
}