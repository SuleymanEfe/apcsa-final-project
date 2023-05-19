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

    /**
    * @return the ID of the vehicle.
    */
    public int getID() {
        return id;
    }

    /**
    * @return the type of the vehicle in int format (See constants.java).
    */
    public int getType() {
        return type;
    }

    /**
    * @return the color of the vehicle.
    */
    public String getColor() {
        return color;
    }

    /**
    * @return the price of the vehicle.
    */
    public int getPrice() {
        return price;
    }

    /**
    * @return the number of seats of the vehicle.
    */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
    * @return the maximum speed of the vehicle.
    */
    public int getSpeed() {
        return speed;
    }

    /**
    * @return the year of the vehicle.
    */
    public int getYear() {
        return year;
    }

    /**
    * @return the mileage of the vehicle.
    */
    public int getMileage() {
        return mileage;
    }

    /**
    * @return a string representation of the vehicle, including its ID, type, year, color, price, number of seats, speed, and mileage.
    */
    public String toString() {
        String[] vehicleTypes = {"SUV", "Motorcycle", "Truck", "Sedan", "Sports Car"};
        String vehicleType = vehicleTypes[type];

        return "Vehicle #" + id + ": \n\tType: " + vehicleType + "\n\tYear: " + year + "\n\tColor: " + color + "\n\tPrice: $" + price + "\n\tNumber of seats: " + 
            numberOfSeats + "\n\tSpeed: " + speed + " mph\n\tMileage: " + mileage + " miles";
    }
}
