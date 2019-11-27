
package se.pizzaOrder;


import java.io.FileNotFoundException;
import java.io.IOException;

import se.baker.Baker;
import se.pickUp.PickUp;


/**
 *
 * @author rimazivkovic
 */
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Menu menu = new Menu();
		PickUp pickUp = new PickUp();
		Baker baker = new Baker(pickUp);
		
		CoreSystem coreSystem = new CoreSystem(menu, baker);
		coreSystem.displayMenu();
	}
}