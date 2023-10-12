package myCoffeeMachineTesting;

import myCoffeeMachine.MyCoffeeMachine;
import javax.swing.*;
import java.io.IOException;

/**
 * Class for testing of implementation methods of class MyCoffeeMachine.
 *
 * @author Martin Dekanovský
 */
public class MyCoffeeMachineTester {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new MyCoffeeMachine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
