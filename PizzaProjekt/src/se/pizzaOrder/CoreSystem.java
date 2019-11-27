package se.pizzaOrder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.baker.Baker;
import se.pizzaOrder.products.Pizza;
import se.pizzaOrder.products.Topping;
import se.pizzaOrder.products.Type;

/**
 *
 * CoreSystem klassen ger användaren val till att beställa mat från en pizza
 * restaurang och håller koll på kundens kundvagn.
 * 
 */

public class CoreSystem {

    private static final int MAX_TOPPINGS = 2;
    private static final String ERRORMASSAGE = "Du har angivit fel val! Försök igen...";
    private Scanner sc = new Scanner(System.in);
    private List<Order> orders = new ArrayList<>();

    private Menu menu;
    private Baker baker;
    private ShoppingCart shoppingCart = new ShoppingCart();

    public CoreSystem(Menu menu, Baker baker) {
        this.menu = menu;
        this.baker = baker;
    }
    
    /**
     * Visar huvudmenyn av olika val man kan beställa och anropar de metoder 
     * som krävs för hantering
     * @throws java.io.FileNotFoundException
     */
       
    
    public void displayMenu() throws FileNotFoundException, IOException {

        System.out.println("················································");
        System.out.println("              Pizza Palatset");
        System.out.println("················································");

        while (true) {
            System.out.println("\nAnge ditt val ");
            int choice = nextInt("\n1. Beställa Pizza " + "\n2. Beställa Dricka" + "\n3. Beställa Tillbehör"
                    + "\n4. Varukorg/betalning" + "\n5. Avbryt");

            Product product = null;
            switch (choice) {
                case 1:
                    // product = queryType((Pizza) product);
                    product = displayProducts(menu.getPizzas());
                    product = queryToppings((Pizza) product);
                    break;
                case 2:
                    product = displayProducts(menu.getDrinks());
                    break;
                case 3:
                    product = displayProducts(menu.getSides());
                    break;
                case 4:
                    displayShoppingList();
                    break;
                case 5:
                    shoppingCart = new ShoppingCart();
                    displayMenu();
                    break;
                default:
                    System.out.println(ERRORMASSAGE);
                    break;
            }
            if (product != null) {
                System.out.println("\nTillagd i varukorg: \n" + product);
                shoppingCart.add(product);
            }
        }
    }
    /**
	 * Frågar användaren om det ska finnas toppings på pizzan
         * Begränsar topping med final där max är två!
         * @param pizza
	 * @return vald pizza med typ ovh toppings
	 */
    private Product queryToppings(Pizza pizza) {
        System.out.println("\nVälj pizza typ: ");
        Type type = (Type) displayProducts(menu.getType());

        System.out.println("\nDu kan ha max " + MAX_TOPPINGS + " toppings på din pizza!");
        List<Topping> toppings = new ArrayList<>();

        while (true) {
            switch (nextInt("0.klar 1.lägg till topping")) {
                case 0:
                    return pizza.customize(toppings, type);
                case 1:
                    Topping topping = (Topping) displayProducts(menu.getToppings());
                    if (topping != null) {
                        System.out.println("\n" + topping.getName() + "har lagts till på pizzan " + pizza.getName() + "\n");
                        toppings.add(topping);
                        if (toppings.size() >= MAX_TOPPINGS) {
                            System.out.println("Max antal toppings på pizzan!");
                            return pizza.customize(toppings, type);
                        }
                    }
                    break;
            }
        }
    }
    /**
	 * Visar en dynamisk meny av produkten och retunerar valet användaren har
	 * gjort
	 * 
	 * @param products
	 *            en lista av produkter att visa en meny av från kalssen Menu
	 * @return Produkten som användaren valde!
	 */
    public Product displayProducts(List<? extends Product> products) {
        System.out.println("\nMeny");
        while (true) {
            int number = 1;
            for (Product product : products) {
                System.out.println("" + number + ". " + product);
                number++;
            }
            int selection = nextInt("Ange ditt val: ");

            if (selection < 1 || selection > products.size()) {
                System.out.println(ERRORMASSAGE);
            } else {
                return products.get(selection - 1);
            }
        }
    }
        /**
	 * Ger användaren val till att betala eller beställa mer. Vid betalning får
	 * man totala konstnaden och de valda produkterna konverteras till en order
         * @throws java.io.IOException
	 */
    public void processOrder() throws IOException {
        System.out.println("\nVarukorg: ");
        System.out.println("------------------------------------------------");
        String filePath = "src/se/pizzaOrder/OrderFile/Orders.txt";
        Double totalPrice = 0.0;

        shoppingCart.print();

        for (Product product : shoppingCart.getShoppingList()) {
            totalPrice = totalPrice + product.getPrice();
        }

        System.out.println("\nDen totala summan är:  " + totalPrice + " kr");

        int input = nextInt("\n1.Lägg till" + "\n0.Betala " + totalPrice + " kr");
        if (input != 0) {
            displayMenu();
        } else {
            Order order = new Order(shoppingCart);
            orders.add(order);

            System.out.println("\nSätt in kortet och ange din 4 siffriga pinkod: ");
            String inputPin = sc.nextLine();

            try (FileWriter file = new FileWriter(filePath, true);) {
                BufferedWriter bw = new BufferedWriter(file);
                PrintWriter output = new PrintWriter(bw);

                if (inputPin.length() == 4) {
                    System.out.println("\nDin beställning har registrerats!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Ditt ordernummer: " + order.getOrderNumber());

                    output.println(order.toString());
                    output.close();
                    baker.startBaking(new File(filePath), order);
                    shoppingCart = new ShoppingCart();

                } else {
                    System.out.println("medges ej");
                    processOrder();
                }
            } catch (FileNotFoundException | InterruptedException ex) {
                System.out.println("Kunde inte registrera beställning.");
                processOrder();
            } finally {
                System.out.println("Tack för ditt besök. Välkommen åter!");
                shoppingCart = new ShoppingCart();
                displayMenu();
            }
        }
    }
        /**
	 * Tvingar användaren att skriva in ett nummer
	 * 
	 * @param description
	 *            information för användaren
	 * @return numret som användaren har skrivit in
	 */
    public int nextInt(String description) {
        while (true) {
            System.out.println(description);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException nFE) {
                System.out.println("Mata in endast in siffror");
            }
        }
    }
         /**
	 * Visar vad som finns i varukorgen
	 */
    public void displayShoppingList() throws FileNotFoundException, IOException {

        System.out.println("\nVarukorg: ");
        System.out.println("------------------------------------------------");

        if (!shoppingCart.getShoppingList().isEmpty()) {
            shoppingCart.print();
        } else {
            System.out.println("\nVarukorgen är tom");
            return;
        }

        while (true) {
            System.out.println("\nAnge ditt val ");
            int choice = nextInt("\n1. Lägg till " + "\n2. Ta bort" + "\n3. Betala" + "\n4. Avbryt");

            Product product = null;
            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    System.out.println("\nVarukorg; ");
                    removeItem();
                    break;
                case 3:
                    processOrder();
                    break;
                case 4:
                    System.out.println("Tack för ditt besök. Välkommen åter!");
                    shoppingCart = new ShoppingCart();
                    displayMenu();
                    break;
                default:
                    System.out.println(ERRORMASSAGE);
                    break;
            }
        }
    }
    //metoden tar bort vara från varukorgen med hjälp av arraylist index
    public void removeItem() throws FileNotFoundException, IOException {
        System.out.println("------------------------------------------------");
        shoppingCart.getShoppingList().forEach((product) -> {
            System.out.println(shoppingCart.getShoppingList().indexOf(product) + ".  " + product);
        });
        try {
            int input = nextInt("\n1.Ta bort  2.Tillbaka");
            switch (input) {
                case 2:
                    return;
                case 1:
                    System.out.println("\nVilken vara vill du ta bort");
                    int selection = nextInt("Ange ditt val: ");
                    if (selection > shoppingCart.getProducts().indexOf(shoppingCart)
                            || selection <= shoppingCart.getProducts().indexOf(shoppingCart)) {

                        shoppingCart.getProducts().remove(selection);
                        displayShoppingList();
                    }
                default:
                    System.out.println(ERRORMASSAGE);
                    break;
            }
        } catch (IndexOutOfBoundsException iOB) {
            System.out.println(ERRORMASSAGE);
        } finally {
            displayShoppingList();
        }

    }
}
