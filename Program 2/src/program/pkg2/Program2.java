
package program.pkg2;

import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println ("Hur gammal är du?");
        int age = sc.nextInt();
        
        System.out.println ("skriv n antal år som du");
        int input = sc.nextInt();
        
        int total = age + input;
        
        System.out.println ("Om "+input+" år är du "+total+" år gammal.");
        
        

    }
    
}
