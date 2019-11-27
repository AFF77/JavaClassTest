package se.pizzaOrder.products;


import java.util.Collections;
import java.util.List;


/**
 * En pizza klass med typ och toppings
 */
public class PizzaCustom extends Pizza {
	
	private final Pizza pizza;
	private final Type type;
	private final List<Topping> toppings;
	
	public PizzaCustom(Pizza pizza, Type type, List<Topping> toppings) {
		super(pizza.getName(), pizza.getPrice());
		this.pizza = pizza;
		this.type = type;
		this.toppings = toppings;
	}
	
	public List<Topping> getToppings() {
		return Collections.unmodifiableList(toppings);
	}
	
	public Pizza getPizza() {
		return pizza;
	}
	
	public Type getType() {
		return type;
	}
	
	/**
	 * @return priset av pizzan plus toppings
	 */
	@Override
	public Double getPrice() {
		double price = super.getPrice();
		
		price += toppings.stream().mapToDouble((topping) -> topping.getPrice()).sum();
		price += getType().getPrice();
		
		return price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName()).append("(").append(getType().getName()).append(")   ").append(getPrice())
				.append(" kr").append("\n");
		
		toppings.forEach((topping) -> {
			sb.append(" + ").append(topping.getName()).append("\n");
		});
		if (toppings.size() > 0) {
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}
}
