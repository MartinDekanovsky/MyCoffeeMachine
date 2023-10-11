package myCoffeeMachine;

public class MyCoffeeMachine {

    private int amountOfWater = 0;
    private int amountOfCoffee = 0;

    public MyCoffeeMachine(int amountOfWater, int amountOfCoffee) {
        this.amountOfWater = amountOfWater;
        this.amountOfCoffee = amountOfCoffee;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public int getAmountOfCoffee() {
        return amountOfCoffee;
    }

    public void setAmountOfWater(int waterRefillAmount) {
        if (waterRefillAmount > 2000 - getAmountOfWater()) {
            System.out.println("Water tank capacity is 2000mL. Only " + (2000 - getAmountOfWater()) + "mL more can be added.");
        } else {
            amountOfWater += waterRefillAmount;
        }
    }

    public void setAmountOfCoffee(int coffeeRefillAmount) {
        if (coffeeRefillAmount > 50 - getAmountOfCoffee()) {
            System.out.println("Coffee tank capacity is 50g. Only " + (50 - getAmountOfCoffee()) + "g more can be added.");
        } else {
            amountOfCoffee += coffeeRefillAmount;
        }
    }

    public void clean() {
        if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for cleaning. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 50;
            System.out.println("Coffee machine has been cleaned");
        }
    }

    public void steamMilk() {
        if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for steaming. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 50;
            System.out.println("Steaming done.");
        }
    }

    public void makeOneSmallCoffee() {
        if (getAmountOfCoffee() < 5) {
            System.out.println("Not enough coffee! Please add at least " + (5 - getAmountOfCoffee()) + "g.");
        } else if (getAmountOfWater() < 50) {
            System.out.println("Not enough water! 50mL are needed for one small coffee. Please add at least " + (50 - getAmountOfWater()) + "mL.");
        } else {
            amountOfCoffee -= 5;
            amountOfWater -= 100;
            System.out.println("One small coffee done.");
        }
    }
}
