public class Vehicle {
    private int id;
    private int type;
    private String color;
    private int price;
    private int numberOfSeats;
    private int speed;
    private int year;
    private int mileage;

    public Vehicle(int id, int type, String color, int price, int numberOfSeats, int speed, int year, int mileage) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.speed = speed;
        this.year = year;
        this.mileage = mileage;
    }

    // Post-condition: Returns the ID of the vehicle.
    public int getID() {
        return id;
    }

    // Post-condition: Returns the type of the vehicle.
    public int getType() {
        return type;
    }

    // Post-condition: Returns the color of the vehicle.
    public String getColor() {
        return color;
    }

    // Post-condition: Returns the price of the vehicle.
    public int getPrice() {
        return price;
    }

    // Post-condition: Returns the number of seats of the vehicle.
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    // Post-condition: Returns the speed of the vehicle.
    public int getSpeed() {
        return speed;
    }

    // Post-condition: Returns the year of the vehicle.
    public int getYear() {
        return year;
    }

    // Post-condition: Returns the mileage of the vehicle.
    public int getMileage() {
        return mileage;
    }

    // Post-condition: Returns a string representation of the vehicle, including its ID, type, year, color, price, number of seats, speed, and mileage.
    public String toString() {
        String vehicleType = "";

        switch (type) {
            case 0:
                // SUV
                vehicleType = "SUV";
                break;
            case 1:
                // MOTORCYCLE
                vehicleType = "Motorcycle";
                break;
            case 2:
                // TRUCK
                vehicleType = "Truck";
                break;
            case 3:
                // SEDAN
                vehicleType = "Sedan";
                break;
            case 4:
                // SPORTS CAR
                vehicleType = "Sports Car";
                break;
        }

        return "Vehicle #" + id + ": \n\tType: " + vehicleType + "\n\tYear: " + year + "\n\tColor: " + color + "\n\tPrice: $" + price + "\n\tNumber of seats: " + numberOfSeats + "\n\tSpeed: " + speed + " mph\n\tMileage: " + mileage + " miles";
    }
}
