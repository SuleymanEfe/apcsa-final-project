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
        System.out.println("What type of vehicle are you looking for?");
        processType();
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
        System.out.println("");
    	spacer();
        System.out.println("What would you like to do?");
        System.out.println("Please enter one of the following commands:");
        System.out.println("    - \"change type\" :      search for a different type of vehicle (Sedan, Truck, etc.).");
        System.out.println("    - \"color\" :            search for vehicles of a specific color.");
        System.out.println("    - \"price range\" :      search for vehicles within a specific price range.");
        System.out.println("    - \"speed range\" :      search for vehicles within a specific speed range.");
        System.out.println("    - \"year range\" :       search for vehicles within a specific year range.");
        System.out.println("    - \"mileage range\" :    search for vehicles within a specific mileage range.");
        System.out.println("    - \"sort by price\" :    view all vehicles sorted by price (lowest to highest).");
        System.out.println("    - \"sort by speed\" :    view all vehicles sorted by speed (highest to lowest).");
        System.out.println("    - \"sort by year\" :     view all vehicles sorted by year (newest to oldest)");
        System.out.println("    - \"sort by mileage\" :  view all vehicles sorted by mileage (lowest to highest).");
        System.out.println("    - \"purchase vehicle\" :    purchase an available car.");
        System.out.println("    - \"exit\" :             exit the dealership.");
    }

    /**
     * Method to get an input and store it as a static variable.
     */
    public static void getInput() {
        System.out.print(">>> ");
        input = scanner.nextLine().trim().toLowerCase();
        System.out.println("");
    }


    /**
     * 
     * Methods to process different inputs.
     * Identifies the requested function and calls appropriate methods as needed.
     */


    public static void processInput() {
        switch(input) {
            // change type of vehicle user is looking for 
            case ("change type"): {
                processType();
                break;
            }
            
            // search by parameter
            case ("color"): {
                processColor();
                break;
            }
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
            
            case ("purchase vehicle"): {
            	processPurchaseCars();
            	break;
            }
            
            // exit program
            case ("exit"): {
                processExit();
                break;
            }
            
            // if invalid input
            default: {
            	processInvalidInput();
            }
        }
    }
    
    private static void processType() {
        System.out.println("Please enter one of the type IDs:");
        System.out.println("    - \"0\" :   SUV");
        System.out.println("    - \"1\" :   Motorcycle");
        System.out.println("    - \"2\" :   Truck");
        System.out.println("    - \"3\" :   Sedan");
        System.out.println("    - \"4\" :   Sports car");
        getInput();
        if(input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
        	dealership.searchByType(Integer.valueOf(input));
        }
        else {
        	processInvalidInput();
        	processType();
        }
    }
    
    private static void processColor() {
    	System.out.println("Please enter one of the following colors:");
        System.out.println("    - \"white\"");
        System.out.println("    - \"black\"");
        System.out.println("    - \"gray\"");
        System.out.println("    - \"silver\"");
        System.out.println("    - \"green\"");
        System.out.println("    - \"yellow\"");
        System.out.println("    - \"bronze\"");
        getInput();
        if(input.equals("white") || input.equals("black") || input.equals("gray") || input.equals("silver") || input.equals("green") || input.equals("yellow") || input.equals("bronze")) {
        	dealership.searchByColor(input);
        }
        else {
        	processInvalidInput();
        	processColor();
        }
    }
    
    private static void processPurchaseCars() {
    	System.out.println("Enter the ID number of the vehicle you would like to purchase: ");
    	getInput();
    	if(dealership.purchaseVehicle(Integer.valueOf(input))) {
    		System.out.println("Congratulations! You have successfully purchased your vehicle.\nYou can continue browsing, or enter 'exit' to exit the dealership.");
    	}
    	else {
    		System.out.println("Sorry, that vehicle does not exist in our inventory. Please try again...");
    		processPurchaseCars();
    	}
    }

    
    private static void processExit() {
        spacer();
        System.out.println("We hope you enjoyed your time at the dealership!");
        System.out.println("Closing the app...");
        scanner.close();
    }

    private static void processInvalidInput() {
        System.out.println("Sorry, that input is invalid. Please try again...");
    }

}
 