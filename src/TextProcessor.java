import java.util.Scanner;

public class TextProcessor {
    private static Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;
    public static String input;

    /**
     * Method to print an introduction about the Dealership.
     */
    public static void introduction(Dealership newDealership) {
        dealership = newDealership;
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
        System.out.println("How do you want to view the available cars?");
        System.out.println("Please enter one of the following commands:");
        System.out.println("    - \"all\" :              view all cars currently available at the dealership.");
        System.out.println("    - \"type\" :             search for cars of a specific type (Sedan, Truck, etc.).");
        System.out.println("    - \"color\" :            search for cars of a specific color.");
        System.out.println("    - \"price range\" :      search for cars within a specific price range.");
        System.out.println("    - \"speed range\" :      search for cars within a specific speed range.");
        System.out.println("    - \"year range\" :       search for cars within a specific year range.");
        System.out.println("    - \"mileage range\" :    search for cars within a specific mileage range.");
        System.out.println("    - \"sort by price\" :    view all cars sorted by price (lowest to highest).");
        System.out.println("    - \"sort by speed\" :    view all cars sorted by speed (highest to lowest).");
        System.out.println("    - \"sort by year\" :     view all cars sorted by year (newest to oldest)");
        System.out.println("    - \"sort by mileage\" :  view all cars sorted by mileage (lowest to highest).");
        processInputViewCars();
    }
    private static void processInputViewCars() {
        getInput();
        switch(input) {
            case ("all"): {
                dealership.printVehicles(dealership.allVehicles);
                break;
            }

            // search for type or color
            case ("type"): {
                System.out.println("Please enter one of the type IDs:");
                System.out.println("    - \"0\" :   SUV");
                System.out.println("    - \"1\" :   Motorcycle");
                System.out.println("    - \"2\" :   Truck");
                System.out.println("    - \"3\" :   Sedan");
                System.out.println("    - \"4\" :   Sports car");
                getInput();
                dealership.searchByType(Integer.valueOf(input));
                break;
            }
            case ("color"): {
                System.out.println("Please enter one of the following colors:");
                System.out.println("    - \"white\"");
                System.out.println("    - \"black\"");
                System.out.println("    - \"gray\"");
                System.out.println("    - \"silver\"");
                System.out.println("    - \"green\"");
                System.out.println("    - \"yellow\"");
                System.out.println("    - \"bronze\"");
                getInput();
                dealership.searchByColor(input);
                break;
            }

            // search for a range
            case ("price range"): {
                System.out.println("Please enter a minimum price:");
                getInput();
                int minPrice = Integer.valueOf(input);
                System.out.println("Please enter a maximum price:");
                getInput();
                int maxPrice = Integer.valueOf(input);
                dealership.searchByPriceRange(minPrice, maxPrice);
                break;
            }
            case ("speed range"): {
                System.out.println("Please enter a minimum speed:");
                getInput();
                int minSpeed = Integer.valueOf(input);
                System.out.println("Please enter a maximum speed:");
                getInput();
                int maxSpeed = Integer.valueOf(input);
                dealership.searchBySpeedRange(minSpeed, maxSpeed);
                break;
            }
            case ("year range"): {
                System.out.println("Please enter a minimum year:");
                getInput();
                int minYear = Integer.valueOf(input);
                System.out.println("Please enter a maximum year:");
                getInput();
                int maxYear = Integer.valueOf(input);
                dealership.searchByYearRange(minYear, maxYear);
                break;
            }
            case ("mileage range"): {
                System.out.println("Please enter a minimum mileage:");
                getInput();
                int minMileage = Integer.valueOf(input);
                System.out.println("Please enter a maximum mileage:");
                getInput();
                int maxMileage = Integer.valueOf(input);
                dealership.searchByMileageRange(minMileage, maxMileage);
                break;
            }

            // sort by parameter
            case ("sort by price"): {
                dealership.sortByPrice();
                break;
            }
            case ("sort by speed"): {
                dealership.sortBySpeed();
                break;
            }
            case ("sort by year"): {
                dealership.sortByYear();
                break;
            }
            case ("sort by mileage"): {
                dealership.sortByMileage();
                break;
            }
        }
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
        System.out.println("");
        System.out.println("Sorry, that input is invalid. Please try again...");
    }

}
