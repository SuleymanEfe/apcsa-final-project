import java.util.Scanner;

public class TextProcessor {
    private static Scanner scanner = new Scanner(System.in);
    public static String input;

    /**
     * Method to print an introduction about the Dealership.
     */
    public static void introduction() {
        System.out.println("Welcome to the Dealership!");
        System.out.println("Here, we sell a variety of vehicles.");
        System.out.println("You can purchase them or view their attributes, such as color or age.");
    }

    /**
     * Method to print a "spacer" to separate prompts.
     */
    public static void spacer() {
        System.out.println("=================================================");
    }

    /**
     * Method to print a prompt describing the actions a user can take.
     */
    public static void prompt() {
        spacer();
        System.out.println("What would you like to do?");
        System.out.println("Please enter one of the following commands:");
        System.out.println("    - \"view cars\" :       view all cars currently available at the dealership.");
        System.out.println("    - \"purchase cars\" :   purchase an available car.");
    }

    /**
     * Method to get an input and store it as a static variable.
     */
    public static void getInput() {
        System.out.print(">>> ");
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
                break;
            }
            case ("purchase cars"): {
                processPurchaseCars();
                break;
            }
            case ("exit"): {
                processExit();
                break;
            }
            default: {
                processInvalidInput();
            }
        }
    }


    /**
     * 
     * Methods to process different inputs.
     * 
     */


    private static void processViewCars() {
        System.out.println("");
    }
    private static void processPurchaseCars() {
        System.out.println("");
    }
    private static void processExit() {
        spacer();
        System.out.println("We hope you enjoyed your time at the dealership!");
        System.out.println("Closing the app...");
        scanner.close();
    }
    private static void processInvalidInput() {
        System.out.println("Sorry, that input is invalid. Please try again...");
        System.out.println("");
    }

}
