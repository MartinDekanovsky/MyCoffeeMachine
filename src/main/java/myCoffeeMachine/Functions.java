package myCoffeeMachine;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class represents the functionality of coffee machine.
 */
public class Functions extends MyCoffeeMachine {

    private static int amountOfWater;
    private static int amountOfCoffee;
    private static int amountOfDescaler;
    private static int amountOfDebris;
    private static int coffeesMade;
    private static boolean isCleaningNeeded;

    /**
     * Method for reading coffee machine initial state from txt file.
     */
    public static void getInitialState() throws IOException {
        Scanner scanner = new Scanner(new File("src/main/resources/MyCoffeeMachine.txt"));
        amountOfWater = scanner.nextInt();
        amountOfCoffee = scanner.nextInt();
        amountOfDescaler = scanner.nextInt();
        amountOfDebris = scanner.nextInt();
        coffeesMade = scanner.nextInt();
        isCleaningNeeded = scanner.nextBoolean();
        scanner.close();
    }

    /**
     * Method returns current amount of water present in coffee machine water tank.
     *
     * @return amount of water.
     */
    public static int getAmountOfWater() {
        return amountOfWater;
    }

    /**
     * Method returns current amount of coffee present in coffee machine coffee tank.
     *
     * @return amount of coffee.
     */
    public static int getAmountOfCoffee() {
        return amountOfCoffee;
    }

    /**
     * Method returns current amount of descaler present in coffee machine descaler tank.
     *
     * @return amount of descaler.
     */
    public static int getAmountOfDescaler() {
        return amountOfDescaler;
    }

    /**
     * Method returns current amount of debris present in coffee machine debris tank. Maximum capacity is 50 g.
     *
     * @return amount of debris.
     */
    public static int getAmountOfDebris() {
        return amountOfDebris;
    }

    /**
     * Method returns current amount of coffees made after the last cleaning.
     *
     * @return amount of coffees made after the last cleaning.
     */
    public static int getCoffeesMade() {
        return coffeesMade;
    }

    /**
     * Method finds out whether coffee machine needs to be cleaned or not.
     *
     * @return true or false.
     */
    public static boolean isCleaningNeeded() {
        return isCleaningNeeded;
    }

    /**
     * Method finds out whether coffee machine needs to be descaled or not.
     *
     * @return true or false.
     */
    public static boolean isDescalingNeeded() {
        return getCoffeesMade() >= 10;
    }

    /**
     * Method sets amount of water present in coffee machine water tank. Maximum capacity is 2000 ml.
     *
     * @param waterRefillAmount amount of water to be added.
     */
    public static void setAmountOfWater(JTextField waterRefillAmount) {
        try {
            int amount = Integer.parseInt(waterRefillAmount.getText());
            if (amount < 1) {
                addTextToTextArea("Please enter positive integer!\n");
            } else if (amount > 2000 - getAmountOfWater()) {
                addTextToTextArea("Water tank capacity is 2000 ml. Only " + (2000 - getAmountOfWater()) + " ml more can be added.\n");
            } else {
                amountOfWater += amount;
                addTextToTextArea(amount + " ml of water added.\n");
            }
        } catch (NumberFormatException e) {
            addTextToTextArea("Please enter positive integer!\n");
        }
        Buttons.addWaterButtonTextField.setText("");
    }
;
    /**
     * Method sets amount of coffee present in coffee machine coffee tank. Maximum capacity is 50 g.
     *
     * @param coffeeRefillAmount amount of coffee to be added.
     */
    public static void setAmountOfCoffee(JTextField coffeeRefillAmount) {
        try {
            int amount = Integer.parseInt(coffeeRefillAmount.getText());
            if (amount < 1) {
                addTextToTextArea("Please enter positive integer!\n");
            } else if (amount > 50 - getAmountOfCoffee()) {
                addTextToTextArea("Coffee tank capacity is 50 g. Only " + (50 - getAmountOfCoffee()) + " g more can be added.\n");
            } else {
                amountOfCoffee += amount;
                addTextToTextArea(amount + " g of coffee added.\n");
            }
        } catch (NumberFormatException e) {
            addTextToTextArea("Please enter positive integer!\n");
        }
        Buttons.addCoffeeButtonTextField.setText("");
    }

    /**
     * Method sets amount of descaler present in coffee machine descaler tank. Maximum capacity is 200 ml.
     *
     * @param descalerRefillAmount amount of descaler to be added.
     */
    public static void setAmountOfDescaler(JTextField descalerRefillAmount) {
        try {
            int amount = Integer.parseInt(descalerRefillAmount.getText());
            if (amount < 1) {
                addTextToTextArea("Please enter positive integer!\n");
            } else if (amount > 200 - getAmountOfDescaler()) {
                addTextToTextArea("Descaler tank capacity is 200 ml. Only " + (200 - getAmountOfDescaler()) + " ml more can be added.\n");
            } else {
                amountOfDescaler += amount;
                addTextToTextArea(amount + " ml of descaler added.\n");
            }
        } catch (NumberFormatException e) {
            addTextToTextArea("Please enter positive integer!\n");
        }
        Buttons.addDescalerButtonTextField.setText("");
    }

    /**
     * Method for steaming of milk. 50 ml of water is needed for steaming.
     */
    public static void steamMilk() {
        if (isDescalingNeeded()) {
            addTextToTextArea("Descaling of coffee machine needed!\n");
        } else if (getAmountOfWater() < 50) {
            addTextToTextArea("Not enough water! 50 ml are needed for steaming. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfWater -= 50;
            addTextToTextArea("Steaming done.\n");
        }
    }

    /**
     * Method for making one small coffee. 5 g of coffee and 50 ml of water is needed.
     */
    public static void makeOneSmallCoffee() {
        if (isDescalingNeeded()) {
            addTextToTextArea("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            addTextToTextArea("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 45) {
            addTextToTextArea("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 5) {
            addTextToTextArea("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 50) {
            addTextToTextArea("Not enough water! 50 ml are needed for one small coffee. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 50;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaningNeeded = true;
            addTextToTextArea("One small coffee done.\n");
        }
    }

    /**
     * Method for making two small coffees. 10 g of coffee and 100 ml of water is needed.
     */
    public static void makeTwoSmallCoffees() {
        if (isDescalingNeeded()) {
            addTextToTextArea("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            addTextToTextArea("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 40) {
            addTextToTextArea("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 10) {
            addTextToTextArea("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 100) {
            addTextToTextArea("Not enough water! 100 ml are needed for two small coffees. Please add at least " + (100 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 100;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaningNeeded = true;
            addTextToTextArea("Two small coffees done.\n");
        }
    }

    /**
     * Method for making one large coffee. 5 g of coffee and 100 ml of water is needed.
     */
    public static void makeOneLargeCoffee() {
        if (isDescalingNeeded()) {
            addTextToTextArea("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            addTextToTextArea("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 45) {
            addTextToTextArea("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 5) {
            addTextToTextArea("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 100) {
            addTextToTextArea("Not enough water! 100 ml are needed for one large coffee. Please add at least " + (100 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 100;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaningNeeded = true;
            addTextToTextArea("One large coffee done.\n");
        }
    }

    /**
     * Method for making two large coffees. 10 g of coffee and 200 ml of water is needed.
     */
    public static void makeTwoLargeCoffees() {
        if (isDescalingNeeded()) {
            addTextToTextArea("Descaling of coffee machine needed!\n");
        } else if (isCleaningNeeded()) {
            addTextToTextArea("Cleaning needed!\n");
        } else if (getAmountOfDebris() > 40) {
            addTextToTextArea("Please empty the debris tank!\n");
        } else if (getAmountOfCoffee() < 10) {
            addTextToTextArea("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + " g.\n");
        } else if (getAmountOfWater() < 200) {
            addTextToTextArea("Not enough water! 200 ml are needed for two large coffees. Please add at least " + (200 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 200;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaningNeeded = true;
            addTextToTextArea("Two large coffees done.\n");
        }
    }

    /**
     * Method for cleaning the coffee machine pipes. 50 ml of water is needed for cleaning.
     * Cleaning has to be done after each coffee making process.
     */
    public static void clean() {
        if (!isCleaningNeeded()) {
            addTextToTextArea("Cleaning not needed!\n");
        } else if (getAmountOfWater() < 50) {
            addTextToTextArea("Not enough water! 50 ml are needed for cleaning. Please add at least " + (50 - getAmountOfWater()) + " ml.\n");
        } else {
            amountOfWater -= 50;
            isCleaningNeeded = false;
            addTextToTextArea("Coffee machine has been cleaned.\n");
        }
    }

    /**
     * Method for descaling the coffee machine. 100 ml of descaler is needed for descaling.
     * Descaling has to be done after 10 or more coffees are prepared.
     */
    public static void descale() {
        if (!isDescalingNeeded()) {
            addTextToTextArea("Descaling not needed!\n");
        } else if (getAmountOfDescaler() < 100) {
            addTextToTextArea("Not enough descaler! 100 ml are needed for descaling. Please add at least " + (100 - getAmountOfDescaler()) + " ml.\n");
        } else {
            amountOfDescaler -= 100;
            coffeesMade = 0;
            addTextToTextArea("Coffee machine has been descaled.\n");
        }
    }

    /**
     * Method for removing all debris from coffee machine debris tank.
     */
    public static void removeDebris() {
        if (getAmountOfDebris() == 0) {
            addTextToTextArea("Debris tank is already empty!\n");
        } else {
            amountOfDebris = 0;
            addTextToTextArea("Debris has been removed.\n");
        }
    }

    /**
     * Method shows the current state of coffee machine.
     */
    public static void showCoffeeMachineState() {
        addTextToTextArea("Water: " + getAmountOfWater() + ", Coffee: " + getAmountOfCoffee() + ", Descaler: " + getAmountOfDescaler()
                + ", Debris: " + getAmountOfDebris() + ", Coffees made: " + getCoffeesMade() + "\nCleaning needed: " + isCleaningNeeded()
                + ", Descaling needed: " + isDescalingNeeded() + "\n");
    }

    /**
     * Method simulates switching-off the coffee machine.
     * Its state is remembered for later use by writing it to the txt file.
     *
     * @throws FileNotFoundException
     */
    public static void switchOff() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/main/resources/MyCoffeeMachine.txt");
        writer.println(getAmountOfWater() + "\n" + getAmountOfCoffee() + "\n" + getAmountOfDescaler() + "\n"
                + getAmountOfDebris() + "\n" + getCoffeesMade() + "\n" + isCleaningNeeded());
        writer.close();
        System.exit(0);
    }
}