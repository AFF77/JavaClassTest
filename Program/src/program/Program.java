
package program;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println ("Hur gammal är du?");
        
        int age = sc.nextInt();
        
        System.out.println ("Du är " +age+ " år gammal.");
    }
    
}
