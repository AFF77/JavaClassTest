package se.pizzaOrder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShoppingCart {
	private List<Product> products = new ArrayList<>();
	
	public ShoppingCart() {
		
	}
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void print() {
		if (products.isEmpty()) {
			System.out.println("Din varukorg är tom");
		}
		else {
			products.forEach((product) -> {
				System.out.println(product);
			});
		}
	}
	
	public void printNames() {
		if (products.isEmpty()) {
			System.out.println("Din varukorg är tom");
		}
		else {
			products.forEach((cart) -> {
				System.out.println(cart.getName());
			});
		}
	}

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getShoppingList() {
        return Collections.unmodifiableList(products);
    }

    public String getName(int orderNumber) {
        return products.get(orderNumber).getName();
    }

    @Override
    public String toString() {
        return " " + products;
    }
}
