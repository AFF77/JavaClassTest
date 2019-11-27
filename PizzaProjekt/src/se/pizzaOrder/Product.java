package se.pizzaOrder;

public abstract class Product {
	
	private final String name;
	private final Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName() + "\t\t" + getPrice() + " kr";
	}
	
}
