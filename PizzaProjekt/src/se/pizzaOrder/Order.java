package se.pizzaOrder;

public class Order {
	private static int orderNumberIncrement = 0;
	private final int orderNumber;
	
	private final ShoppingCart shoppingCart;
	
	public Order(ShoppingCart shoppingCart) {
		orderNumber = ++orderNumberIncrement;
		this.shoppingCart = shoppingCart;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

    @Override
    public String toString() {
        return "\nOrderNumber = " + orderNumber + " " + shoppingCart.toString();
    }
        
	
}
