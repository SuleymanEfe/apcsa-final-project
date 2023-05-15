
public class Main {
    public static void main(String[] args)
    {
    	Dealership dealership = new Dealership();
    	dealership.initialize();
    	//System.out.println(dealership.allVehicles);


        TextProcessor.introduction(dealership);
        // Main logic loop.
        do {
            TextProcessor.prompt();
            TextProcessor.getInput();
            TextProcessor.processInput();
        } 
        while (!TextProcessor.input.equals("exit")); // Closes the program when the user inputs "exit".
    	
    }
}
