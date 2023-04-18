
public class Vehicle {
	private String color;
	private int price;
	private int numberOfSeats;
	
	public Vehicle(String color, int price, int numberOfSeats) {
		this.color = color;
		this.price = price;
		this.numberOfSeats = numberOfSeats;
		
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
}
