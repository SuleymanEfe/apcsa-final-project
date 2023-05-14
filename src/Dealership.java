import java.util.*;

public class Dealership {
    ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>(); //all vehicles in dealership
    ArrayList<Vehicle> currVehicles = new ArrayList<Vehicle>(); //vehicles of specific type user is looking for
    
    public void initialize() {
        for(int i = 0; i < 20; i++){
            int randomType = getRandomNumber(1, 4); // This defines the type of the vehicle. 4 is sport cars which is also the last ID. SEE: Constants.java

            String randomColor = getRandomColor();
            int randomPrice = getRandomNumber(Constants.MIN_PRICE, Constants.MAX_PRICE);
            int randomYear = getRandomNumber(Constants.MIN_YEAR, Constants.MAX_YEAR);
            int randomMileage = getRandomNumber(Constants.MIN_MILEAGE, Constants.MAX_MILEAGE);
            int randomSpeed = 0;
            int randomNumOfSeats = 0;

            Vehicle vehicle = null;

            switch(randomType){
                case 0:
                    // SUV
                    randomSpeed = getRandomNumber(Constants.SUV_MIN_SPEED, Constants.SUV_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SUV_MIN_NUMBER_OF_SEATS, Constants.SUV_MAX_NUMBER_OF_SEATS);
                    vehicle = new SUV(Constants.SUV_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 1:
                    // MOTORCYCLE
                    randomSpeed = getRandomNumber(Constants.MOTORCYCLE_MIN_SPEED, Constants.MOTORCYCLE_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.MOTORCYCLE_MIN_NUMBER_OF_SEATS, Constants.MOTORCYCLE_MAX_NUMBER_OF_SEATS);
                    vehicle = new Motorcycle(Constants.MOTORCYCLE_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 2:
                    // TRUCK
                    randomSpeed = getRandomNumber(Constants.TRUCK_MIN_SPEED, Constants.TRUCK_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.TRUCK_MIN_NUMBER_OF_SEATS, Constants.TRUCK_MAX_NUMBER_OF_SEATS);
                    vehicle = new Truck(Constants.TRUCK_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 3:
                    // SEDAN
                    randomSpeed = getRandomNumber(Constants.SEDAN_MIN_SPEED, Constants.SEDAN_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SEDAN_MIN_NUMBER_OF_SEATS, Constants.SEDAN_MAX_NUMBER_OF_SEATS);
                    vehicle = new Sedan(Constants.SEDAN_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 4:
                    // SPORT
                    randomSpeed = getRandomNumber(Constants.SPORTS_MIN_SPEED, Constants.SPORTS_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SPORTS_MIN_NUMBER_OF_SEATS, Constants.SPORTS_MAX_NUMBER_OF_SEATS);
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
    
    
    public int getRandomNumber(int min, int max) {
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
    
    //vehicles in speed range
    public void searchBySpeedRange(int minSpeed, int maxSpeed) {
    	ArrayList<Vehicle> inSpeedRange = new ArrayList<Vehicle>();
    	
    	for(Vehicle v: currVehicles) {
			if(v.getSpeed() >= minSpeed && v.getSpeed() <= maxSpeed) {
				inSpeedRange.add(v);
			}
		}
		
		printVehicles(inSpeedRange);
    }
    
    //vehicles in year range
    public void searchByYearRange(int minYear, int maxYear) {
    	ArrayList<Vehicle> inYearRange = new ArrayList<Vehicle>();
    	
    	for(Vehicle v: currVehicles) {
			if(v.getYear() >= minYear && v.getYear() <= maxYear) {
				inYearRange.add(v);
			}
		}
		
		printVehicles(inYearRange);
    }
    
    //vehicles in mileage range
    public void searchByMileageRange(int minMileage, int maxMileage) {
    	ArrayList<Vehicle> inMileageRange = new ArrayList<Vehicle>();
    	
    	for(Vehicle v: currVehicles) {
			if(v.getMileage() >= minMileage && v.getMileage() <= maxMileage) {
				inMileageRange.add(v);
			}
		}
		
		printVehicles(inMileageRange);
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
                return Integer.compare(v2.getSpeed(), v1.getSpeed());
            }
        });
    	
    	sortedBySpeed = currVehicles;
    	
    	printVehicles(sortedBySpeed);
    }
    
    //newest to oldest year 
    public void sortByYear() {
    	ArrayList<Vehicle> sortedByYear = new ArrayList<Vehicle>();
    	
    	Collections.sort(currVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v2.getYear(), v1.getYear());
            }
        });
    	
    	sortedByYear = currVehicles;
    	
    	printVehicles(sortedByYear);
    }
    
    //least to greatest mileage
    public void sortByMileage() {
    	ArrayList<Vehicle> sortedByMileage = new ArrayList<Vehicle>();
    	
    	Collections.sort(currVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getMileage(), v2.getMileage());
            }
        });
    	
    	sortedByMileage = currVehicles;
    	
    	printVehicles(sortedByMileage);
    }
    
    //display vehicles
    public void printVehicles(ArrayList<Vehicle> veh) {
    	for(Vehicle v: veh) {
    		v.toString();
    	}
    }
}
