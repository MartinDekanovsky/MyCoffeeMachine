package myCoffeeMachine;

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
public class MyCoffeeMachine {

    private int amountOfWater;
    private int amountOfCoffee;
    private int amountOfDescaler;
    private int amountOfDebris;
    private int coffeesMade;
    private boolean isCleaned;

    /**
     * Constructor simulates switching-on an existing coffee machine by reading its state from txt file.
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
        this.isCleaned = scanner.nextBoolean();
        scanner.close();
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
     * Method returns current amount of debris present in coffee machine debris tank.
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
     * Method finds out whether coffee machine is cleaned or not.
     *
     * @return true or false.
     */
    public boolean isCleaned() {
        return isCleaned;
    }

    /**
     * Method sets amount of water present in coffee machine water tank.
     *
     * @param waterRefillAmount amount of water to be added.
     */
    public void setAmountOfWater(int waterRefillAmount) {
        if (waterRefillAmount > 2000 - getAmountOfWater()) {
            System.out.println("Water tank capacity is 2000mL. Only " + (2000 - getAmountOfWater()) + "mL more can be added.");
        } else {
            amountOfWater += waterRefillAmount;
        }
    }

    /**
     * Method sets amount of coffee present in coffee machine coffee tank.
     *
     * @param coffeeRefillAmount amount of coffee to be added.
     */
    public void setAmountOfCoffee(int coffeeRefillAmount) {
        if (coffeeRefillAmount > 50 - getAmountOfCoffee()) {
            System.out.println("Coffee tank capacity is 50g. Only " + (50 - getAmountOfCoffee()) + "g more can be added.");
        } else {
            amountOfCoffee += coffeeRefillAmount;
        }
    }

    /**
     * Method sets amount of descaler present in coffee machine descaler tank.
     *
     * @param descalerRefillAmount amount of descaler to be added.
     */
    public void setAmountOfDescaler(int descalerRefillAmount) {
        if (descalerRefillAmount > 200 - getAmountOfDescaler()) {
            System.out.println("Descaler tank capacity is 200mL. Only " + (200 - getAmountOfDescaler()) + "mL more can be added.");
        } else {
            amountOfDescaler += descalerRefillAmount;
        }
    }

    /**
     * Method for steaming of milk.
     */
    public void steamMilk() {
        if (getCoffeesMade() >= 10) {
            System.out.println("Descaling of coffee machine needed!");
        } else if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for steaming. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 50;
            System.out.println("Steaming done.");
        }
    }

    /**
     * Method for making one small coffee.
     */
    public void makeOneSmallCoffee() {
        if (getCoffeesMade() >= 10) {
            System.out.println("Descaling of coffee machine needed!");
        } else if (!isCleaned()) {
            System.out.println("Cleaning needed!");
        } else if (getAmountOfDebris() > 45) {
            System.out.println("Please empty the debris tank!");
        } else if (getAmountOfCoffee() < 5) {
            System.out.println("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + "g.");
        } else if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for one small coffee. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 50;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaned = false;
            System.out.println("One small coffee done.");
        }
    }

    /**
     * Method for making two small coffees.
     */
    public void makeTwoSmallCoffees() {
        if (getCoffeesMade() >= 10) {
            System.out.println("Descaling of coffee machine needed!");
        } else if (!isCleaned()) {
            System.out.println("Cleaning needed!");
        } else if (getAmountOfDebris() > 40) {
            System.out.println("Please empty the debris tank!");
        } else if (getAmountOfCoffee() < 10) {
            System.out.println("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + "g.");
        } else if (getAmountOfWater() < 100) {
            System.out.println("Not enough water! 100mL are needed for two small coffees. Please add at least " + (100 - getAmountOfWater()) + "mL.");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 100;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaned = false;
            System.out.println("Two small coffees done.");
        }
    }

    /**
     * Method for making one large coffee.
     */
    public void makeOneLargeCoffee() {
        if (getCoffeesMade() >= 10) {
            System.out.println("Descaling of coffee machine needed!");
        } else if (!isCleaned()) {
            System.out.println("Cleaning needed!");
        } else if (getAmountOfDebris() > 45) {
            System.out.println("Please empty the debris tank!");
        } else if (getAmountOfCoffee() < 5) {
            System.out.println("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + "g.");
        } else if (getAmountOfWater() < 100) {
            System.out.println("Not enough water! 100mL are needed for one large coffee. Please add at least " + (100 - getAmountOfWater()) + "mL.");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 100;
            amountOfDebris += 5;
            coffeesMade++;
            isCleaned = false;
            System.out.println("One large coffee done.");
        }
    }

    /**
     * Method for making two large coffees.
     */
    public void makeTwoLargeCoffees() {
        if (getCoffeesMade() >= 10) {
            System.out.println("Descaling of coffee machine needed!");
        } else if (!isCleaned()) {
            System.out.println("Cleaning needed!");
        } else if (getAmountOfDebris() > 40) {
            System.out.println("Please empty the debris tank!");
        } else if (getAmountOfCoffee() < 10) {
            System.out.println("Not enough coffee! Please add at least " + (10 - getAmountOfCoffee()) + "g.");
        } else if (getAmountOfWater() < 200) {
            System.out.println("Not enough water! 200mL are needed for two large coffees. Please add at least " + (200 - getAmountOfWater()) + "mL.");
        } else {
            amountOfCoffee -= 10;
            amountOfWater -= 200;
            amountOfDebris += 10;
            coffeesMade += 2;
            isCleaned = false;
            System.out.println("Two large coffees done.");
        }
    }

    /**
     * Method for cleaning the coffee machine pipes.
     */
    public void clean() {
        if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for cleaning. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 50;
            isCleaned = true;
            System.out.println("Coffee machine has been cleaned.");
        }
    }

    /**
     * Method for descaling the coffee machine.
     */
    public void descale() {
        if (getAmountOfDescaler() < 200) {
            System.out.println("Not enough descaler! 10mL are needed for cleaning. Please add at least " + (200 - getAmountOfDescaler()) + "mL.");
        } else {
            amountOfDescaler -= 100;
            coffeesMade = 0;
            System.out.println("Coffee machine has been descaled.");
        }
    }

    /**
     * Method for removing all debris from coffee machine debris tank.
     */
    public void removeDebris() {
        amountOfDebris = 0;
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
        + getAmountOfDebris() + "\n" + getCoffeesMade() + "\n" + isCleaned());
        writer.close();
    }
}
