
package se.pickUp;


import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


public class PickUp {
	
	public PickUp() {
		
	}
	
	public void pickUp(String order) throws FileNotFoundException, InterruptedException {
		System.out.println("THE PICK UP IS NOW DELIVERING THE ORDER!");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("THE PICK UP IS NOW DELIVERED!");
		
	}
}