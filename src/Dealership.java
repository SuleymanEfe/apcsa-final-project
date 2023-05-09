import java.util.*;

public class Dealership {
    ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>(); //all vehicles in dealership
    ArrayList<Vehicle> currVehicles = new ArrayList<Vehicle>(); //vehicles of specific type user is looking for
    
    public void initialize() {
        for(int i = 0; i < 20; i++){
            int randomType = getRandom(1, 4); // This defined the type of the vehicle. 4 is sport cars which is also the last ID. SEE: Constants.java

            String randomColor = getRandomColor();
            int randomPrice = getRandom(Constants.MIN_PRICE, Constants.MAX_PRICE);
            int randomYear = getRandom(Constants.MIN_YEAR, Constants.MAX_YEAR);
            int randomMileage = getRandom(Constants.MIN_MILEAGE, Constants.MAX_MILEAGE);
            int randomSpeed = 0;
            int randomNumOfSeats = 0;

            Vehicle vehicle = null;

            switch(randomType){
                case 0:
                    randomSpeed = getRandom(Constants.SUV_MIN_SPEED, Constants.SUV_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.SUV_MIN_NUMBER_OF_SEATS, Constants.SUV_MAX_NUMBER_OF_SEATS);
                    vehicle = new SUV(Constants.SUV_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 1:
                    randomSpeed = getRandom(Constants.MOTORCYCLE_MIN_SPEED, Constants.MOTORCYCLE_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.MOTORCYCLE_MIN_NUMBER_OF_SEATS, Constants.MOTORCYCLE_MAX_NUMBER_OF_SEATS);
                    vehicle = new Motorcycle(Constants.MOTORCYCLE_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 2:
                    randomSpeed = getRandom(Constants.TRUCK_MIN_SPEED, Constants.TRUCK_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.TRUCK_MIN_NUMBER_OF_SEATS, Constants.TRUCK_MAX_NUMBER_OF_SEATS);
                    vehicle = new Truck(Constants.TRUCK_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 3:
                    randomSpeed = getRandom(Constants.SEDAN_MIN_SPEED, Constants.SEDAN_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.SEDAN_MIN_NUMBER_OF_SEATS, Constants.SEDAN_MAX_NUMBER_OF_SEATS);
                    vehicle = new Sedan(Constants.SEDAN_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 4:
                    randomSpeed = getRandom(Constants.SPORTS_MIN_SPEED, Constants.SPORTS_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.SPORTS_MIN_NUMBER_OF_SEATS, Constants.SPORTS_MAX_NUMBER_OF_SEATS);
                    vehicle = new SportsCar(Constants.SPORTS_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
            }

            allVehicles.add(vehicle);

        }
    }
      
    public String getRandomColor() {
    	String[] colors = Constants.COLORS;
    	
        int rnd = (int)(Math.random()*colors.length);
        return colors[rnd];
    }
    
    
    public int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

    }
    
    //vehicles of specific type 
    public void searchByType(int type) {
    	ArrayList<Vehicle> typeOnly = new ArrayList<Vehicle>();
    	
		for(Vehicle v: allVehicles) {
			if(v.getID() == type) {
				typeOnly.add(v);
			}
		}
		
		currVehicles = typeOnly;
		
		printVehicles(currVehicles);
    }
    
    //vehicles with specific color
    public void searchByColor(String color) {
    	ArrayList<Vehicle> colorOnly = new ArrayList<Vehicle>();
    	
    	for(Vehicle v: currVehicles) {
			if(v.getColor().equals(color)) {
				colorOnly.add(v);
			}
		}
		
		printVehicles(colorOnly);
    }
    
    //vehicles in price range
    public void searchByPriceRange(int minPrice, int maxPrice){
    	ArrayList<Vehicle> inPriceRange = new ArrayList<Vehicle>();
    	
    	for(Vehicle v: currVehicles) {
			if(v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
				inPriceRange.add(v);
			}
		}
		
		printVehicles(inPriceRange);
    }
    
    //lowest to highest price
    public void sortByPrice() {
    	ArrayList<Vehicle> sortedByPrice = new ArrayList<Vehicle>();
    	
    	Collections.sort(currVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getPrice(), v2.getPrice());
            }
        });
    	
    	sortedByPrice = currVehicles;
    	
    	printVehicles(sortedByPrice);
    }
    
    //highest to lowest speed
    public void sortBySpeed() {
    	ArrayList<Vehicle> sortedBySpeed = new ArrayList<Vehicle>();
    	
    	Collections.sort(currVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getSpeed(), v2.getSpeed());
            }
        });
    	
    	sortedBySpeed = currVehicles;
    	
    	printVehicles(sortedBySpeed);
    }

    public void printVehicles(ArrayList<Vehicle> veh) {
    	for(Vehicle v: veh) {
    		v.toString();
    	}
    }
}
