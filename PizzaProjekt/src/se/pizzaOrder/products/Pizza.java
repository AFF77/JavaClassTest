package se.pizzaOrder.products;


import java.util.List;

import se.pizzaOrder.Product;


public class Pizza extends Product {
	
	public Pizza(String name, double price) {
		super(name, price);
	}
	
	/**
	 * Producerar en ny pizza med toppings
	 * 
	 * @param toppings
	 *            som ska appliceras på den här pizzan
         * @param type
	 * @return en ny pizza med toppings eller sig själv om det inte finns några
	 *         toppings
	 */
	public Pizza customize(List<Topping> toppings, Type type) {	
			return new PizzaCustom(this, type, toppings);
		
	}
	
}
