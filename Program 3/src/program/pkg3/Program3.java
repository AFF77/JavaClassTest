
package program.pkg3;

import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println ("Hur många minuter pratade du igår på dagen?");
        
        int minDag = sc.nextInt();
        int summaDag = minDag * 5;
        
        System.out.println ("Hur många minuter pratade du igår på natten?");
        
        int minNatt = sc.nextInt();
        int summaNatt = minNatt * 10;
        
        int total = summaNatt + summaDag;
        
        if (total > 200)
            {
                System.out.println ("Prata mindre!");
            }
        
        if (total < 200)
            {
                System.out.println ("Du får 15% rabbat och ska bara betala "+total * 0.15+" kronor!");
            }
        
        
        
    }
    
}
