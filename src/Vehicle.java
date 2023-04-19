
public class Vehicle {
	private String color;
	private int price;
	private int numberOfSeats;
	private int speed;
	
	public Vehicle(String color, int price, int numberOfSeats, int speed) {
		this.color = color;
		this.price = price;
		this.numberOfSeats = numberOfSeats;
		this.speed = speed;
		
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public int getSpeed() {
		return this.speed;
	}
}
