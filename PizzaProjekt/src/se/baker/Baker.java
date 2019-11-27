
package se.baker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import se.pickUp.PickUp;
import se.pizzaOrder.Order;



public class Baker {
	
	private PickUp pickUp;
	private static final Pattern orderPattern = Pattern.compile("OrderNumber\\s*=\\s*(\\d+).*");
	
	public Baker(PickUp pickUp) {
		this.pickUp = pickUp;
	}

	public void startBaking(File file, Order order) throws InterruptedException, IOException {
		System.out.println("Tack för ditt köp, din order behandlas!\n");
                System.out.println("················································");
                System.out.println("              Pizza Palatset");
                System.out.println("················································");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("BEEEEEEEP, ORDERN ÄR KLAR OCH REDO FÖR LEVERANS!");
		TimeUnit.SECONDS.sleep(2);
		pickUp.pickUp(order.toString());
		removeOrder(file, order.getOrderNumber());
		TimeUnit.SECONDS.sleep(1);
	}
	
	public void removeOrder(File file, int orderNumber) throws IOException {
		List<String> lines = Files.readAllLines(file.toPath());
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			Matcher matcher = orderPattern.matcher(line);
			if (matcher.matches()) {
				int lineOrderNumber = Integer.parseInt(matcher.group(1));
				if (lineOrderNumber == orderNumber) {
					while (true) {
						if (lines.remove(i).contains("]")) {
							break;
						}
					}
					break;
				}
			}
		}
		
		Files.write(file.toPath(), lines);
	}
	
	
}
