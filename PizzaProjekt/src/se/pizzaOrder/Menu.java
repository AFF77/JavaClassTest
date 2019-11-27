package se.pizzaOrder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.pizzaOrder.products.Drink;
import se.pizzaOrder.products.Pizza;
import se.pizzaOrder.products.Sides;
import se.pizzaOrder.products.Topping;
import se.pizzaOrder.products.Type;


public class Menu {
	
	private List<Pizza> pizzas = new ArrayList<>();
	private List<Drink> drinks = new ArrayList<>();
	private List<Sides> sides = new ArrayList<>();
	private List<Topping> toppings = new ArrayList<>();
        private List<Type> types = new ArrayList<>();
	
	public Menu() {
		pizzas.add(new Pizza("BasPizza    ",45));
		pizzas.add(new Pizza("Margherita  ",73));
		pizzas.add(new Pizza("Vesuvio     ",69));
		pizzas.add(new Pizza("Capricciosa ",79));
		pizzas.add(new Pizza("Calzone     ",82));
		pizzas.add(new Pizza("Vegan       ",65));
		
		drinks.add(new Drink("Coca cola   ",20));
		drinks.add(new Drink("Fanta       ",20));
		drinks.add(new Drink("Juice       ",25));
		drinks.add(new Drink("IsTea       ",35));
		drinks.add(new Drink("Mjölk       ",15));
		drinks.add(new Drink("Loka        ",15));
		
		sides.add(new Sides("Vitlöksbröd  ",20));
		sides.add(new Sides("Pommes frites",30));
		sides.add(new Sides("Ostrullar    ",30));
		sides.add(new Sides("Pizza Sallad ",10));
		sides.add(new Sides("Bearnese sås ",20));
		sides.add(new Sides("kyckling vingar",45));
		
		toppings.add(new Topping("Extra ost ",10));
		toppings.add(new Topping("Bacon ",15));
		toppings.add(new Topping("Oxfilé ",25));
		toppings.add(new Topping("Kyckling ",20));
		toppings.add(new Topping("Oliver ",15));
		toppings.add(new Topping("Scampi ",25));
                
                types.add(new Type("Italian",0.0));
		types.add(new Type("American",25.0));         
    }

    public List<Pizza> getPizzas() {
        return Collections.unmodifiableList(pizzas); // säkerhet, ingen kan
        // bort vid get metoden.
    }

    public List<Drink> getDrinks() {
        return Collections.unmodifiableList(drinks);
    }

    public List<Sides> getSides() {
        return Collections.unmodifiableList(sides);
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public List<Type> getType() {
        return Collections.unmodifiableList(types);
    }
        
}
