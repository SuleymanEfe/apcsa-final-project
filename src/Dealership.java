import java.util.*;

public class Dealership {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    
    public void initialize() {
	    String randomColor = getRandomColor();
	    int randomPrice = getRandom(Constants.MIN_PRICE, Constants.MAX_PRICE);
	    int randomType = getRandom(1, 4); // This defined the type of the vehicle. 4 is sport cars which is also the last ID. SEE: Constants.java
	    
	    System.out.println(randomColor);
	    System.out.println(randomPrice);
	    System.out.println(randomType);
    }
      
    public String getRandomColor() {
    	String[] colors = Constants.COLORS;
    	
        int rnd = (int)(Math.random()*colors.length);
        return colors[rnd];
    }
    
    
    public int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

    }
}
