
public class Vehicle {
	private int id;
	private String color;
	private int price;
	private int numberOfSeats;
	private int speed; 
	private int year;
	private int mileage;
	
	public Vehicle(int id, String color, int price, int numberOfSeats, int speed, int year, int mileage) {
		this.id = id;
		this.color = color;
		this.price = price;
		this.numberOfSeats = numberOfSeats;
		this.speed = speed;
		this.year = year;
		this.mileage = mileage;
	}
	
	public int getID() {
		return id;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public int getSpeed() {
		return speed;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMileage() {
		return mileage; 
	}
	
	//public String toString(){}
}
