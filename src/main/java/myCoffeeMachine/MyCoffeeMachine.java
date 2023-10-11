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
        amountOfCoffee += coffeeRefillAmount;
    }

    public void clean() {
        if (getAmountOfWater() < 100) {
            System.out.println("Not enough water! 100mL are needed for cleaning. Please add at least " + (100 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 100;
            System.out.println("Coffee machine has been cleaned");
        }
    }

    public void steamMilk() {
        if (getAmountOfWater() < 100) {
            System.out.println("Not enough water! 100mL are needed for steaming. Please add at least " + (100 - getAmountOfWater()) + "mL.");
        } else {
            amountOfWater -= 100;
            System.out.println("Steaming done.");
        }
    }
}
