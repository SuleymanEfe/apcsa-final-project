import java.util.*;

public class Dealership {
    ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>(); // all vehicles in the dealership
    ArrayList<Vehicle> currVehicles = new ArrayList<Vehicle>(); // vehicles of a specific type the user is looking for
    
    public void initialize() {
        for (int i = 1000; i < 1100; i++) { // initializing 100 vehicles in the dealership
            int id = i; // unique 4-digit ID for each vehicle
            int randomType = getRandomNumber(0, 4); // This defines the type of the vehicle. 4 is sports cars, which is also the last ID. SEE: Constants.java
            String randomColor = getRandomColor();
            int randomPrice = getRandomNumber(Constants.MIN_PRICE, Constants.MAX_PRICE);
            int randomYear = getRandomNumber(Constants.MIN_YEAR, Constants.MAX_YEAR);
            int randomMileage = getRandomNumber(Constants.MIN_MILEAGE, Constants.MAX_MILEAGE);
            int randomSpeed = 0;
            int randomNumOfSeats = 0;

            Vehicle vehicle = null;

            switch (randomType) {
                case 0:
                    // SUV
                    randomSpeed = getRandomNumber(Constants.SUV_MIN_SPEED, Constants.SUV_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SUV_MIN_NUMBER_OF_SEATS, Constants.SUV_MAX_NUMBER_OF_SEATS);
                    vehicle = new SUV(id, Constants.SUV_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 1:
                    // MOTORCYCLE
                    randomSpeed = getRandomNumber(Constants.MOTORCYCLE_MIN_SPEED, Constants.MOTORCYCLE_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.MOTORCYCLE_MIN_NUMBER_OF_SEATS, Constants.MOTORCYCLE_MAX_NUMBER_OF_SEATS);
                    vehicle = new Motorcycle(id, Constants.MOTORCYCLE_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 2:
                    // TRUCK
                    randomSpeed = getRandomNumber(Constants.TRUCK_MIN_SPEED, Constants.TRUCK_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.TRUCK_MIN_NUMBER_OF_SEATS, Constants.TRUCK_MAX_NUMBER_OF_SEATS);
                    vehicle = new Truck(id, Constants.TRUCK_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 3:
                    // SEDAN
                    randomSpeed = getRandomNumber(Constants.SEDAN_MIN_SPEED, Constants.SEDAN_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SEDAN_MIN_NUMBER_OF_SEATS, Constants.SEDAN_MAX_NUMBER_OF_SEATS);
                    vehicle = new Sedan(id, Constants.SEDAN_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
                case 4:
                    // SPORT
                    randomSpeed = getRandomNumber(Constants.SPORTS_MIN_SPEED, Constants.SPORTS_MAX_SPEED);
                    randomNumOfSeats = getRandomNumber(Constants.SPORTS_MIN_NUMBER_OF_SEATS, Constants.SPORTS_MAX_NUMBER_OF_SEATS);
                    vehicle = new SportsCar(id, Constants.SPORTS_ID, randomColor, randomPrice, randomNumOfSeats, randomSpeed, randomYear, randomMileage);
                    break;
            }

            allVehicles.add(vehicle);
        }
    }
    
    // Post-condition: Returns a randomly selected color from the Constants.COLORS array.
    public String getRandomColor() {
        String[] colors = Constants.COLORS;
        int rnd = (int)(Math.random() * colors.length);
        return colors[rnd];
    }
    
    // Pre-condition: min and max are valid integer values such that min <= max.
    // Post-condition: Returns a random number within the range of min and max (inclusive).
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }
    
    // Pre-condition: type is a valid vehicle type ID.
    // Post-condition: Filters the vehicles in allVehicles list and populates currVehicles list with vehicles of the specified type.
    //                 If there are no vehicles of the specified type, prints an appropriate message.
    public void searchByType(int type) {
        ArrayList<Vehicle> typeOnly = new ArrayList<Vehicle>();

        for (Vehicle v : allVehicles) {
            if (v.getType() == type) {
                typeOnly.add(v);
            }
        }

        currVehicles = typeOnly;

        if (typeOnly.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type you are looking for currently in our dealership.");
        } else {
            printVehicles(currVehicles);
        }
    }
    
    // Pre-condition: color is a valid color string.
    // Post-condition: Filters the vehicles in currVehicles list and populates colorOnly list with vehicles of the specified color.
    //                 If there are no vehicles of the specified color, prints an appropriate message.
    public void searchByColor(String color) {
        ArrayList<Vehicle> colorOnly = new ArrayList<Vehicle>();

        for (Vehicle v : currVehicles) {
            if (v.getColor().toLowerCase().trim().equals(color)) {
                colorOnly.add(v);
            }
        }

        if (colorOnly.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type with the color you are looking for currently in our dealership.");
        } else {
            printVehicles(colorOnly);
        }
    }
    
    // Pre-condition: minPrice and maxPrice are valid integer values such that minPrice <= maxPrice.
    // Post-condition: Filters the vehicles in currVehicles list and populates inPriceRange list with vehicles within the specified price range.
    //                 If there are no vehicles within the specified price range, prints an appropriate message.
    public void searchByPriceRange(int minPrice, int maxPrice) {
        ArrayList<Vehicle> inPriceRange = new ArrayList<Vehicle>();

        for (Vehicle v : currVehicles) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                inPriceRange.add(v);
            }
        }

        if (inPriceRange.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type with the price you are looking for currently in our dealership.");
        } else {
            printVehicles(inPriceRange);
        }
    }
    
    // Pre-condition: minSpeed and maxSpeed are valid integer values such that minSpeed <= maxSpeed.
    // Post-condition: Filters the vehicles in currVehicles list and populates inSpeedRange list with vehicles within the specified speed range.
    //                 If there are no vehicles within the specified speed range, prints an appropriate message.
    public void searchBySpeedRange(int minSpeed, int maxSpeed) {
        ArrayList<Vehicle> inSpeedRange = new ArrayList<Vehicle>();

        for (Vehicle v : currVehicles) {
            if (v.getSpeed() >= minSpeed && v.getSpeed() <= maxSpeed) {
                inSpeedRange.add(v);
            }
        }

        if (inSpeedRange.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type with the speed you are looking for currently in our dealership.");
        } else {
            printVehicles(inSpeedRange);
        }
    }
    
    // Pre-condition: minYear and maxYear are valid integer values such that minYear <= maxYear.
    // Post-condition: Filters the vehicles in currVehicles list and populates inYearRange list with vehicles within the specified year range.
    //                 If there are no vehicles within the specified year range, prints an appropriate message.
    public void searchByYearRange(int minYear, int maxYear) {
        ArrayList<Vehicle> inYearRange = new ArrayList<Vehicle>();

        for (Vehicle v : currVehicles) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                inYearRange.add(v);
            }
        }

        if (inYearRange.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type with the year you are looking for currently in our dealership.");
        } else {
            printVehicles(inYearRange);
        }
    }
    
    // Pre-condition: minMileage and maxMileage are valid integer values such that minMileage <= maxMileage.
    // Post-condition: Filters the vehicles in currVehicles list and populates inMileageRange list with vehicles within the specified mileage range.
    //                 If there are no vehicles within the specified mileage range, prints an appropriate message.
    public void searchByMileageRange(int minMileage, int maxMileage) {
        ArrayList<Vehicle> inMileageRange = new ArrayList<Vehicle>();

        for (Vehicle v : currVehicles) {
            if (v.getMileage() >= minMileage && v.getMileage() <= maxMileage) {
                inMileageRange.add(v);
            }
        }

        if (inMileageRange.size() == 0) {
            System.out.println("Sorry, there are no vehicles of the type with the mileage you are looking for currently in our dealership.");
        } else {
            printVehicles(inMileageRange);
        }
    }
    
    // Pre-condition: currVehicles list is not null.
    // Post-condition: Sorts the vehicles in currVehicles list by price in ascending order and prints the sorted list.
    public void sortByPrice() {
        ArrayList<Vehicle> sortedByPrice = new ArrayList<Vehicle>(currVehicles);
        
        Collections.sort(sortedByPrice, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getPrice(), v2.getPrice());
            }
        });

        printVehicles(sortedByPrice);
    }
    
    // Pre-condition: currVehicles list is not null.
    // Post-condition: Sorts the vehicles in currVehicles list by speed in descending order and prints the sorted list.
    public void sortBySpeed() {
        ArrayList<Vehicle> sortedBySpeed = new ArrayList<Vehicle>(currVehicles);
        
        Collections.sort(sortedBySpeed, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v2.getSpeed(), v1.getSpeed());
            }
        });

        printVehicles(sortedBySpeed);
    }
    
    // Pre-condition: currVehicles list is not null.
    // Post-condition: Sorts the vehicles in currVehicles list by year in descending order and prints the sorted list.
    public void sortByYear() {
        ArrayList<Vehicle> sortedByYear = new ArrayList<Vehicle>(currVehicles);
        
        Collections.sort(sortedByYear, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v2.getYear(), v1.getYear());
            }
        });

        printVehicles(sortedByYear);
    }
    
    // Pre-condition: currVehicles list is not null.
    // Post-condition: Sorts the vehicles in currVehicles list by mileage in ascending order and prints the sorted list.
    public void sortByMileage() {
        ArrayList<Vehicle> sortedByMileage = new ArrayList<Vehicle>(currVehicles);
        
        Collections.sort(sortedByMileage, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getMileage(), v2.getMileage());
            }
        });

        printVehicles(sortedByMileage);
    }
    
    // Pre-condition: veh list is not null.
    // Post-condition: Prints the details of vehicles in the veh list.
    public void printVehicles(ArrayList<Vehicle> veh) {
        for (Vehicle v : veh) {
            System.out.println(v.toString());
        }
    }
    
    // Pre-condition: id is a valid vehicle ID.
    // Post-condition: If a vehicle with the specified id exists in allVehicles list, removes the vehicle and returns true.
    //                 Otherwise, returns false.
    public boolean purchaseVehicle(int id) {
        for (int i = 0; i < allVehicles.size(); i++) {
            if (allVehicles.get(i).getID() == id) {
                allVehicles.remove(i);
                return true;
            }
        }
        return false;
    }
}
