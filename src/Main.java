
public class Main {
    public static void main(String[] args)
    {
    	Dealership dealership = new Dealership();
    	dealership.initialize();
    	System.out.println(dealership.vehicles);


        TextProcessor.introduction();
        // Main logic loop.
        do {
            TextProcessor.prompt();
            TextProcessor.getInput();
            TextProcessor.processInput();
        } 
        while (TextProcessor.input != "exit"); // Closes the program when the user inputs "exit".
    	
    }
}
