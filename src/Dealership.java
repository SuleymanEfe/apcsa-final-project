import java.util.*;

public class Dealership {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    
    public void initialize() {
        for(int i = 0; i < 20; i++){
            int randomType = getRandom(1, 4); // This defined the type of the vehicle. 4 is sport cars which is also the last ID. SEE: Constants.java

            String randomColor = getRandomColor();
            int randomPrice = getRandom(Constants.MIN_PRICE, Constants.MAX_PRICE);
            int randomSpeed = 0;
            int randomNumOfSeats = 0;

            Vehicle vehicle = null;

            switch(randomType){
                case 0:
                    randomSpeed = getRandom(Constants.SUV_MIN_NUMBER_OF_SEATS, Constants.SUV_MAX_NUMBER_OF_SEATS);
                    randomNumOfSeats = getRandom(Constants.SUV_MIN_NUMBER_OF_SEATS, Constants.SUV_MAX_NUMBER_OF_SEATS);
                    vehicle = new SUV(randomColor, randomPrice, randomNumOfSeats, randomSpeed);
                    break;
                case 1:
                    randomSpeed = getRandom(Constants.MOTORCYCLE_MIN_SPEED, Constants.MOTORCYCLE_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.MOTORCYCLE_MIN_NUMBER_OF_SEATS, Constants.MOTORCYCLE_MAX_NUMBER_OF_SEATS);
                    vehicle = new Motorcycle(randomColor, randomPrice, randomNumOfSeats, randomSpeed);
                    break;
                case 2:
                    randomSpeed = getRandom(Constants.TRUCK_MIN_SPEED, Constants.TRUCK_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.TRUCK_MIN_NUMBER_OF_SEATS, Constants.TRUCK_MAX_NUMBER_OF_SEATS);
                    vehicle = new Truck(randomColor, randomPrice, randomNumOfSeats, randomSpeed);
                    break;
                case 3:
                    randomSpeed = getRandom(Constants.SEDAN_MIN_SPEED, Constants.SEDAN_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.SEDAN_MIN_NUMBER_OF_SEATS, Constants.SEDAN_MAX_NUMBER_OF_SEATS);
                    vehicle = new Sedan(randomColor, randomPrice, randomNumOfSeats, randomSpeed);
                    break;
                case 4:
                    randomSpeed = getRandom(Constants.SPORT_MIN_SPEED, Constants.SPORT_MAX_SPEED);
                    randomNumOfSeats = getRandom(Constants.SPORTS_MIN_NUMBER_OF_SEATS, Constants.SPORTS_MAX_NUMBER_OF_SEATS);
                    vehicle = new SportsCar(randomColor, randomPrice, randomNumOfSeats, randomSpeed);
                    break;
            }

            vehicles.add(vehicle);

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
}
