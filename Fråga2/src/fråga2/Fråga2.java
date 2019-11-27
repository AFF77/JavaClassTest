/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fråga2;

import java.util.Scanner;

/**
 *
 * @author aysen
 */
public class Fråga2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args)
	{
		/* Olika strängar för att se om det går att knäcka koder */
		
		String code = ". .(. .(. .). .). . . . . .";
		String code2 = ". .(. .(. . .). . . . . . .";
		String code3 = ". .(. . . .). .(. . . .). .";
		String code4 = ". . . .). .). .(. .(. . . .";
		String code5 = ". .(. .). .). .(. .(. .). .";
		String code6 = ". . . . . . . . . . . . . . .";
		
		System.out.println(match(code));
		System.out.println(match(code2));
		System.out.println(match(code3));
		System.out.println(match(code4));
		System.out.println(match(code5));
		
	}
	
	public static boolean match(String code)
	{
		boolean matched = false;
		if (code.matches("^[ ().]*$"))// Kollar att strängen bara har
										// paranteser, mellanslag och punkter.
		{
			code = removeSpaces(code);
			code = removeDots(code);
			StringBuilder sbCode = new StringBuilder(code);
			
			if (sbCode.length() != 0)
			{
				if (sbCode.charAt(0) == '(')
				{
					for (int i = 0; i < sbCode.length(); i++)
					{
						if (sbCode.charAt(i) == ')')
						{
							sbCode.deleteCharAt(i);
							sbCode.deleteCharAt(0);
							i = 0;
						}
						
					}
				}
			}
			
			if (sbCode.length() == 0)
			{
				matched = true;
			}
			else
			{
				matched = false;
			}
		}
		
		return matched;
	}
	
	// Tar bort mellanslag
	public static String removeSpaces(String input)
	{
		return input.replaceAll(" ", "");
	}
	
	// Tar bort punkter
	public static String removeDots(String input)
	{
		return input.replaceAll("[.]", "");
	}
        public static boolean positive(int value){
        return value>0;
        }
    
}
