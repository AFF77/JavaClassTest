/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessthenumber;

/**
 *
 * @author aysen
 */
import java.util.*;

public class guessTheNumber {

	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		
		
		int ans = 500;
		
		int high = 1000;
		
		int low = 1;
	
		
		while(true) {
			
			System.out.println(ans);
			
			String fb = f.nextLine();

			if(fb.equals("higher")) {
				low = ans;
				ans = (low + high + 1) / 2;
			}
			if(fb.equals("lower")) {
				high = ans;
				ans = (high + low) / 2;
			}
			if(fb.equals("correct")) {
				break;
			}
			
		}
		f.close();
	}
	
}