package myCoffeeMachine;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Class for creating all coffee machine buttons.
 *
 * @author Martin Dekanovský
 */
public class Buttons extends Functions {

    static JTextField addWaterButtonTextField = new JTextField(4);
    static JTextField addCoffeeButtonTextField = new JTextField(4);
    static JTextField addDescalerButtonTextField = new JTextField(4);

    /**
     * Method for creating panel with refill buttons.
     *
     * @return panel with refill buttons.
     */
    public static JPanel addRefillButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        JButton addWaterButton = new JButton("Add water:");
        addWaterButton.addActionListener(event -> setAmountOfWater(addWaterButtonTextField));

        JButton addCoffeeButton = new JButton("Add coffee:");
        addCoffeeButton.addActionListener(event -> setAmountOfCoffee(addCoffeeButtonTextField));

        JButton addDescalerButton = new JButton("Add descaler:");
        addDescalerButton.addActionListener(event -> setAmountOfDescaler(addDescalerButtonTextField));

        jPanel.add(addWaterButton);
        jPanel.add(addWaterButtonTextField);
        jPanel.add(addCoffeeButton);
        jPanel.add(addCoffeeButtonTextField);
        jPanel.add(addDescalerButton);
        jPanel.add(addDescalerButtonTextField);
        return jPanel;
    }

    /**
     * Method for creating panel with prepare buttons.
     *
     * @return panel with prepare buttons.
     */
    public static JPanel addPrepareButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        JButton steamMilkButton = new JButton("Steam milk");
        steamMilkButton.setBackground(Color.GREEN);
        steamMilkButton.addActionListener(event -> steamMilk());

        JButton makeOneSmallCoffeeButton = new JButton("1 small coffee");
        makeOneSmallCoffeeButton.setBackground(Color.GREEN);
        makeOneSmallCoffeeButton.addActionListener(event -> makeOneSmallCoffee());

        JButton makeTwoSmallCoffeesButton = new JButton("2 small coffees");
        makeTwoSmallCoffeesButton.setBackground(Color.GREEN);
        makeTwoSmallCoffeesButton.addActionListener(event -> makeTwoSmallCoffees());

        JButton makeOneLargeCoffeeButton = new JButton("1 large coffee");
        makeOneLargeCoffeeButton.setBackground(Color.GREEN);
        makeOneLargeCoffeeButton.addActionListener(event -> makeOneLargeCoffee());

        JButton makeTwoLargeCoffeesButton = new JButton("2 large coffees");
        makeTwoLargeCoffeesButton.setBackground(Color.GREEN);
        makeTwoLargeCoffeesButton.addActionListener(event -> makeTwoLargeCoffees());

        jPanel.add(steamMilkButton);
        jPanel.add(makeOneSmallCoffeeButton);
        jPanel.add(makeTwoSmallCoffeesButton);
        jPanel.add(makeOneLargeCoffeeButton);
        jPanel.add(makeTwoLargeCoffeesButton);
        return jPanel;
    }

    /**
     * Method for creating panel with maintenance buttons.
     *
     * @return panel with maintenance buttons.
     */
    public static JPanel addMaintenanceButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        JButton cleanButton = new JButton("Clean");
        cleanButton.setBackground(Color.LIGHT_GRAY);
        cleanButton.addActionListener(event -> clean());

        JButton descaleButton = new JButton("Descale");
        descaleButton.setBackground(Color.LIGHT_GRAY);
        descaleButton.addActionListener(event -> descale());

        JButton removeDebrisButton = new JButton("Remove debris");
        removeDebrisButton.setBackground(Color.LIGHT_GRAY);
        removeDebrisButton.addActionListener(event -> removeDebris());

        jPanel.add(cleanButton);
        jPanel.add(descaleButton);
        jPanel.add(removeDebrisButton);
        return jPanel;
    }

    /**
     * Method for creating panel with general buttons.
     *
     * @return panel with general buttons.
     */
    public static JPanel addGeneralButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        JButton showCoffeeMachineStateButton = new JButton("Show coffee machine state");
        showCoffeeMachineStateButton.setBackground(new Color(150, 121, 105));
        showCoffeeMachineStateButton.addActionListener(event -> showCoffeeMachineState());

        JButton switchOffButton = new JButton("Switch Off");
        switchOffButton.setBackground(Color.RED);
        switchOffButton.addActionListener(event -> {
            try {
                switchOff();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        jPanel.add(showCoffeeMachineStateButton);
        jPanel.add(switchOffButton);
        return jPanel;
    }
}