
package program.pkg5;

import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println ("Hur många minuter pratar du i telefon per månad?");
        
        double min = sc.nextDouble();
        
        if (min < 33)
        {
            System.out.println ("Du tjänar i längden mest på att välja Kontant");
        }
        
        else if (min>33 && min<66)
        {
            System.out.println ("Du tjänar i längden mest på att välja Normal");
        }
            
        else if (min > 66)
        {
            System.out.println ("Du tjänar i längden mest på att välja Plus");
        }
    }
    
}
