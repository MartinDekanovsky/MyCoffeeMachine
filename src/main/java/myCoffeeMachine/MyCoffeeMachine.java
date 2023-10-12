package myCoffeeMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class serves as a simple demonstration of my real-life coffee machine functionality.
 *
 * @author Martin Dekanovský
 */
public class MyCoffeeMachine extends JFrame {

    private int amountOfWater;
    private int amountOfCoffee;
    private int amountOfDescaler;
    private int amountOfDebris;
    private int coffeesMade;
    private boolean isCleaningNeeded;
    private JTextArea textArea;
    private JTextField addWaterButtonTextField;
    private JTextField addCoffeeButtonTextField;
    private JTextField addDescalerButtonTextField;

    /**
     * Constructor simulates switching-on an existing coffee machine by reading its state from txt file.
     * GUI of coffee machine is created, with display and buttons that represent coffee machine functions.
     *
     * @throws IOException
     */
    public MyCoffeeMachine() throws IOException {
        Scanner scanner = new Scanner(new File("src/main/resources/MyCoffeeMachine.txt"));
        this.amountOfWater = scanner.nextInt();
        this.amountOfCoffee = scanner.nextInt();
        this.amountOfDescaler = scanner.nextInt();
        this.amountOfDebris = scanner.nextInt();
        this.coffeesMade = scanner.nextInt();
        this.isCleaningNeeded = scanner.nextBoolean();
        scanner.close();

        setTitle("My coffee machine :)");
        setLayout(new BorderLayout());
        setSize(610, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null); // window will be displayed in the middle of screen
        setVisible(true);

        textArea = new JTextArea();
        textArea.setLayout(new BorderLayout());
        textArea.setEditable(false); // it won't be possible to write into text area
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(textArea); // scroll pane for text area
        add(scrollPane, BorderLayout.CENTER); // scroll pane (with text area) added to JFrame

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); // multiple panels can be added on top of each other
        add(container, BorderLayout.SOUTH); // container added to JFrame

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout()); // buttons will be centered

        JButton addWaterButton = new JButton("Add water:");
        addWaterButtonTextField = new JTextField(4);
        ActionListener addWaterButtonListener = event -> setAmountOfWater(addWaterButtonTextField);
        addWaterButton.addActionListener(addWaterButtonListener);

        JButton addCoffeeButton = new JButton("Add coffee:");
        addCoffeeButtonTextField = new JTextField(4);
        ActionListener addCoffeeButtonListener = event -> setAmountOfCoffee(addCoffeeButtonTextField);
        addCoffeeButton.addActionListener(addCoffeeButtonListener);

        JButton addDescalerButton = new JButton("Add descaler:");
        addDescalerButtonTextField = new JTextField(4);
        ActionListener addDescalerButtonListener = event -> setAmountOfDescaler(addDescalerButtonTextField);
        addDescalerButton.addActionListener(addDescalerButtonListener);

        jPanel1.add(addWaterButton);
        jPanel1.add(addWaterButtonTextField);
        jPanel1.add(addCoffeeButton);
        jPanel1.add(addCoffeeButtonTextField);
        jPanel1.add(addDescalerButton);
        jPanel1.add(addDescalerButtonTextField);
        container.add(jPanel1); // panel added to container

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());

        JButton steamMilkButton = new JButton("Steam milk");
        steamMilkButton.setBackground(Color.GREEN);
        ActionListener steamMilkButtonListener = event -> steamMilk();
        steamMilkButton.addActionListener(steamMilkButtonListener);

        JButton makeOneSmallCoffeeButton = new JButton("1 small coffee");
        makeOneSmallCoffeeButton.setBackground(Color.GREEN);
        ActionListener makeOneSmallCoffeeButtonListener = event -> makeOneSmallCoffee();
        makeOneSmallCoffeeButton.addActionListener(makeOneSmallCoffeeButtonListener);

        JButton makeTwoSmallCoffeesButton = new JButton("2 small coffees");
        makeTwoSmallCoffeesButton.setBackground(Color.GREEN);
        ActionListener makeTwoSmallCoffeesButtonListener = event -> makeTwoSmallCoffees();
        makeTwoSmallCoffeesButton.addActionListener(makeTwoSmallCoffeesButtonListener);

        JButton makeOneLargeCoffeeButton = new JButton("1 large coffee");
        makeOneLargeCoffeeButton.setBackground(Color.GREEN);
        ActionListener makeOneLargeCoffeeButtonListener = event -> makeOneLargeCoffee();
        makeOneLargeCoffeeButton.addActionListener(makeOneLargeCoffeeButtonListener);

        JButton makeTwoLargeCoffeesButton = new JButton("2 large coffees");
        makeTwoLargeCoffeesButton.setBackground(Color.GREEN);
        ActionListener makeTwoLargeCoffeesButtonListener = event -> makeTwoLargeCoffees();
        makeTwoLargeCoffeesButton.addActionListener(makeTwoLargeCoffeesButtonListener);

        jPanel2.add(steamMilkButton);
        jPanel2.add(makeOneSmallCoffeeButton);
        jPanel2.add(makeTwoSmallCoffeesButton);
        jPanel2.add(makeOneLargeCoffeeButton);
        jPanel2.add(makeTwoLargeCoffeesButton);
        container.add(jPanel2);

        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FlowLayout());

        JButton cleanButton = new JButton("Clean");
        cleanButton.setBackground(Color.LIGHT_GRAY);
        ActionListener cleanButtonListener = event -> clean();
        cleanButton.addActionListener(cleanButtonListener);

        JButton descaleButton = new JButton("Descale");
        descaleButton.setBackground(Color.LIGHT_GRAY);
        ActionListener descaleButtonListener = event -> descale();
        descaleButton.addActionListener(descaleButtonListener);

        JButton removeDebrisButton = new JButton("Remove debris");
        removeDebrisButton.setBackground(Color.LIGHT_GRAY);
        ActionListener removeDebrisButtonListener = event -> removeDebris();
        removeDebrisButton.addActionListener(removeDebrisButtonListener);

        jPanel3.add(cleanButton);
        jPanel3.add(descaleButton);
        jPanel3.add(removeDebrisButton);
        container.add(jPanel3);

        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new FlowLayout());

        JButton showCoffeeMachineStateButton = new JButton("Show coffee machine state");
        showCoffeeMachineStateButton.setBackground(new Color(150, 121, 105));
        ActionListener showCoffeeMachineStateButtonListener = event -> showCoffeeMachineState();
        showCoffeeMachineStateButton.addActionListener(showCoffeeMachineStateButtonListener);

        JButton switchOffButton = new JButton("Switch Off");
        switchOffButton.setBackground(Color.RED);
        ActionListener switchOffButtonListener = event -> {
            try {
                switchOff();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        switchOffButton.addActionListener(switchOffButtonListener);

        jPanel4.add(showCoffeeMachineStateButton);
        jPanel4.add(switchOffButton);
        container.add(jPanel4);
    }

    /**
     * Method returns current amount of water present in coffee machine water tank.
     *
     * @return amount of water.
     */
    public int getAmountOfWater() {
        return amountOfWater;
    }

    /**
     * Method returns current amount of coffee present in coffee machine coffee tank.
     *
     * @return amount of coffee.
     */
    public int getAmountOfCoffee() {
        return amountOfCoffee;
    }

    /**
     * Method returns current amount of descaler present in coffee machine descaler tank.
     *
     * @return amount of descaler.
     */
    public int getAmountOfDescaler() {
        return amountOfDescaler;
    }

    /**
     * Method returns current amount of debris present in coffee machine debris tank. Maximum capacity is 50 g.
     *
     * @return amount of debris.
     */
    public int getAmountOfDebris() {
        return amountOfDebris;
    }

    /**
     * Method returns current amount of coffees made after the last cleaning.
     *
     * @return amount of coffees.
     */
    public int getCoffeesMade() {
        return coffeesMade;
    }

    /**
     * Method finds out whether coffee machine needs to be cleaned or not.
     *
     * @return true or false.
     */
    public boolean isCleaningNeeded() {
        return isCleaningNeeded;
    }

    /**
     * Method finds out whether coffee machine needs to be descaled or not.
     *
     * @return true or false.
     */
    public boolean isDescalingNeeded() {
        return getCoffeesMade() >= 10;
    }

    /**
     * Method sets amount of water present in coffee machine water tank. Maximum capacity is 2000 ml.
     *
     * @param waterRefillAmount amount of water to be added.
     */
    public void setAmountOfWater(JTextField waterRefillAmount) {
        try {
            int amount = Integer.parseInt(waterRefillAmount.getText());
            if (amount < 1) {
                textArea.append("Please enter positive integer!\n");
            } else if (amount > 2000 - getAmountOfWater()) {
                textArea.append("Water tank capacity is 2000 ml. Only " + (2000 - getAmountOfWater()) + " ml more can be added.\n");
            } else {
                amountOfWater += amount;
                textArea.append(amount + " ml of water added.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Please enter positive integer!\n");
        }
        addWaterButtonTextField.setText(""); // resets the text field
    }

    /**
     * Method sets amount of coffee present in coffee machine coffee tank. Maximum capacity is 50 g.
     *
     * @param coffeeRefillAmount amount of coffee to be added.
     */
    public void setAmountOfCoffee(JTextField coffeeRefillAmount) {
        try {
            int amount = Integer.parseInt(coffeeRefillAmount.getText());
            if (amount < 1) {
                textArea.append("Please enter positive integer!\n");
            } else if (amount > 50 - getAmountOfCoffee()) {
                textArea.append("Coffee tank capacity is 50 g. Only " + (50 - getAmountOfCoffee()) + " g more can be added.\n");
            } else {
                amountOfCoffee += amount;
                textArea.append(amount + " g of coffee added.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Please enter positive integer!\n");
        }
        addCoffeeButtonTextField.setText("");
    }

    /**
     * Method sets amount of descaler present in coffee machine descaler tank. Maximum capacity is 200 ml.
     *
     * @param descalerRefillAmount amount of descaler to be added.
     */
    public void setAmountOfDescaler(JTextField descalerRefillAmount) {
        try {
            int amount = Integer.parseInt(descalerRefillAmount.getText());
            if (amount < 1) {
                textArea.append("Please enter positive integer!\n");
            } else if (amount > 200 - getAmountOfDescaler()) {
                textArea.append("Descaler tank capacity is 200 ml. Only " + (200 - getAmountOfDescaler()) + " ml more can be added.\n");
            } else {
                amountOfDescaler += amount;
                textArea.append(amount + " ml of descaler added.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Please enter positive integer!\n");
        }
        addDescalerButtonTextField.setText("");
    }

    /**
     * Method for steaming of milk. 50 ml of water is needed for steaming.
     */
    public void steamMilk() {
        if (isDescalingNeeded()) {
            textArea.append("Descaling of coffee machine needed!\n");
        } else if (getAmountOfWater() < 50) {
            textArea.append("Not enough water! 50 ml are needed for steaming. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfWater -= 50;
            textArea.append("Steaming done.\n");
        }
    }

    /**
     * Method for making one small coffee. 5 g of coffee and 50 ml of water is needed.
     */
    public void makeOneSmallCoffee() {
        if (isDescalingNeeded()) {
            textArea.append("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            textArea.append("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 45) {
            textArea.append("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 5) {
            textArea.append("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 50) {
            textArea.append("Not enough water! 50 ml are needed for one small coffee. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 50;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaningNeeded = true;
            textArea.append("One small coffee done.\n");
        }
    }

    /**
     * Method for making two small coffees. 10 g of coffee and 100 ml of water is needed.
     */
    public void makeTwoSmallCoffees() {
        if (isDescalingNeeded()) {
            textArea.append("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            textArea.append("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 40) {
            textArea.append("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 10) {
            textArea.append("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 100) {
            textArea.append("Not enough water! 100 ml are needed for two small coffees. Please add at least " + (100 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 100;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaningNeeded = true;
            textArea.append("Two small coffees done.\n");
        }
    }

    /**
     * Method for making one large coffee. 5 g of coffee and 100 ml of water is needed.
     */
    public void makeOneLargeCoffee() {
        if (isDescalingNeeded()) {
            textArea.append("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            textArea.append("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 45) {
            textArea.append("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 5) {
            textArea.append("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 100) {
            textArea.append("Not enough water! 100 ml are needed for one large coffee. Please add at least " + (100 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 100;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaningNeeded = true;
            textArea.append("One large coffee done.\n");
        }
    }

    /**
     * Method for making two large coffees. 10 g of coffee and 200 ml of water is needed.
     */
    public void makeTwoLargeCoffees() {
        if (isDescalingNeeded()) {
            textArea.append("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            textArea.append("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 40) {
            textArea.append("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 10) {
            textArea.append("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 200) {
            textArea.append("Not enough water! 200 ml are needed for two large coffees. Please add at least " + (200 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 200;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaningNeeded = true;
            textArea.append("Two large coffees done.\n");
        }
    }

    /**
     * Method for cleaning the coffee machine pipes. 50 ml of water is needed for cleaning.
     * Cleaning has to be done after each coffee making process.
     */
    public void clean() {
        if (!isCleaningNeeded()) {
            textArea.append("Cleaning not needed!\n");
        } else if (getAmountOfWater() < 50) {
            textArea.append("Not enough water! 50 ml are needed for cleaning. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfWater -= 50;
            isCleaningNeeded = false;
            textArea.append("Coffee machine has been cleaned.\n");
        }
    }

    /**
     * Method for descaling the coffee machine. 100 ml of descaler is needed for descaling.
     * Descaling has to be done after 10 or more coffees are prepared.
     */
    public void descale() {
        if (!isDescalingNeeded()) {
            textArea.append("Descaling not needed!\n");
        } else if (getAmountOfDescaler() < 100) {
            textArea.append("Not enough descaler! 100 ml are needed for descaling. Please add at least " + (100 - getAmountOfDescaler()) + " ml.\n");
        } else {
            amountOfDescaler -= 100;
            coffeesMade = 0;
            textArea.append("Coffee machine has been descaled.\n");
        }
    }

    /**
     * Method for removing all debris from coffee machine debris tank.
     */
    public void removeDebris() {
        if (getAmountOfDebris() == 0) {
            textArea.append("Debris tank is already empty!\n");
        } else {
            amountOfDebris = 0;
            textArea.append("Debris has been removed.\n");
        }
    }

    /**
     * Method shows the current state of coffee machine.
     */
    public void showCoffeeMachineState() {
        textArea.append("Water: " + getAmountOfWater() + ", Coffee: " + getAmountOfCoffee() + ", Descaler: " + getAmountOfDescaler()
                + ", Debris: " + getAmountOfDebris() + ", Coffees made: " + getCoffeesMade() + "\nCleaning needed: " + isCleaningNeeded()
                + ", Descaling needed: " + isDescalingNeeded() + "\n");
    }

    /**
     * Method simulates switching-off the coffee machine.
     * Its state is remembered for later use by writing it to the txt file.
     *
     * @throws FileNotFoundException
     */
    public void switchOff() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/main/resources/MyCoffeeMachine.txt");
        writer.println(getAmountOfWater() + "\n" + getAmountOfCoffee() + "\n" + getAmountOfDescaler() + "\n"
                + getAmountOfDebris() + "\n" + getCoffeesMade() + "\n" + isCleaningNeeded());
        writer.close();
        System.exit(0);
    }
}
