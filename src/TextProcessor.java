import java.util.Scanner;

public class TextProcessor {
    private static Scanner scanner = new Scanner(System.in);
    public static String input;

    /**
     * Method to print an introduction about the Dealership.
     */
    public static void introduction() {
        System.out.print("");
    }

    /**
     * Method to print a prompt describing the actions a user can take.
     */
    public static void prompt() {
        System.out.print("");
    }

    /**
     * Method to get an input and store it as a static variable.
     */
    public static void getInput() {
        input = scanner.nextLine().trim().toLowerCase();
    }

    /**
     * Method to process an input.
     * Identifies the requested function and calls the appropriate method.
     */
    public static void processInput() {
        switch (input) {
            case ("view cars"): {
                processViewCars();
            }
            case ("purchase cars"): {
                processPurchaseCars();
            }
            case ("exit"): {
                processExit();
            }
            default: {
                processInvalidInput();
            }
        }
    }

    private static void processViewCars() {
        System.out.print("");
    }
    private static void processPurchaseCars() {
        System.out.print("");
    }
    private static void processExit() {
        System.out.print("");
        scanner.close();
    }
    private static void processInvalidInput() {
        System.out.print("");
    }

}
